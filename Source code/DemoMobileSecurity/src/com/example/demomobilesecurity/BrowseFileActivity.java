package com.example.demomobilesecurity;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demomobilesecurity.adapter.ListFileAdpater;
import com.example.demomobilesecurity.entity.FileItem;
import com.example.demomobilesecurity.utility.FileUtils;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class BrowseFileActivity extends BaseActivity {

	@InjectView(R.id.browse_list_file)
	ListView listView;
	@InjectView(R.id.select_file)
	Button selectFile;

	private int currentPostion = -1;

	private List<FileItem> fileItems;
	private String pathFile;

	public boolean isRestoreFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		isRestoreFile = getIntent().getBooleanExtra("IS_RESTORE", false);

		pathFile = getIntent().getStringExtra("CurrentPath");
		if (pathFile == null)
			pathFile = Environment.getExternalStorageDirectory()
					.getAbsolutePath();
		fileUtils.currentPathFile = fileUtils.currentPathFile == null ? Environment
				.getExternalStorageDirectory().getAbsolutePath()
				: fileUtils.currentPathFile;

		fileItems = FileUtils.getFileUtils(getApplication()).getListFileItems(
				pathFile);
		listView.setAdapter(new ListFileAdpater(this, fileItems, isRestoreFile));
		listView.setOnItemClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browse_file, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		this.selectFile();
	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_browse_file;
	}

	@OnClick(R.id.select_file)
	public void selectFile() {

		if (isRestoreFile) {

			for (FileItem fi : fileUtils.currentFileItems) {
				fi.PathFile = fileUtils.currentPathFile + "/" + fi.FileName;
				fileUtils.restoreFileItem(fi, currentPostion);
				sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(fi.PathFile)));
			}
			
			
			MediaScannerConnection.scanFile(this,
					new String[] { fileUtils.currentPathFile }, null,
					new MediaScannerConnection.OnScanCompletedListener() {

						@Override
						public void onScanCompleted(String path, Uri uri) {
							// TODO Auto-generated method stub

						}
					});
			fileUtils.currentFileItems.clear();
			Intent intent = new Intent(this, HiddenActivity.class);
			startActivity(intent);
		} else {
			if (currentPostion < 0) {
				this.showDialog("Warning!", "Please select file or folder!");
				currentPostion = -1;
				return;
			}
			if (currentPostion >= 0) {
				FileItem fileItem = fileItems.get(currentPostion);
				fileUtils.hideFiles(fileItem);
				Intent intent = new Intent(this, ListFilesAcitivity.class);
				startActivity(intent);
			}
		}

		currentPostion = -1;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if (isRestoreFile) {
			currentPostion = 1;
			// user run restore file
			FileItem fileItem = fileItems.get(position);
			if (fileItem.IsFolder) {
				currentPostion = position;

				fileUtils.currentPathFile = fileItem.PathFile;
				Intent intent = new Intent(this, BrowseFileActivity.class);
				intent.putExtra("CurrentPath", fileItem.PathFile);
				intent.putExtra("IS_RESTORE", true);

				startActivity(intent);

			}
		} else {
			// user run add files
			FileItem fileItem = fileItems.get(position);
			if (fileItem.IsFolder) {
				Intent intent = new Intent(this, BrowseFileActivity.class);
				intent.putExtra("CurrentPath", fileItem.PathFile);
				startActivity(intent);
			} else {
				currentPostion = position;
			}
		}

	}

}
