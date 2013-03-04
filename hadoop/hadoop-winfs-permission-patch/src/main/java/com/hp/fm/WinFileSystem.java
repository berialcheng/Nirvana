package com.hp.fm;

import java.io.IOException;

import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

public class WinFileSystem extends LocalFileSystem {

	public WinFileSystem() {
		super();
	}

	@Override
	public boolean mkdirs(Path path, FsPermission permission)
			throws IOException {
		boolean result = super.mkdirs(path);
		this.setPermission(path, permission);
		return result;
	}

	public void setPermission(Path path, FsPermission permission)
			throws IOException {
		try {
			super.setPermission(path, permission);
		} catch (IOException e) {
		}
	}
}
