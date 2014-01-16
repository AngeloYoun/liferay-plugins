/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.repository.external.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.repository.external.ExtRepositoryAdapter;
import com.liferay.repository.external.ExtRepositoryFileVersion;

import java.io.InputStream;

import java.util.Date;

/**
 * @author Iván Zaera
 * @author Sergio González
 */
public class ExtRepositoryFileVersionAdapter
	extends ExtRepositoryModelAdapter<FileVersion> implements FileVersion {

	public ExtRepositoryFileVersionAdapter(
		ExtRepositoryAdapter extRepositoryAdapter, long repositoryEntryId,
		String uuid,
		ExtRepositoryFileEntryAdapter extRepositoryFileEntryAdapter,
		ExtRepositoryFileVersion extRepositoryFileVersion) {

		super(
			extRepositoryAdapter, repositoryEntryId, uuid,
			extRepositoryFileVersion);

		_extRepositoryFileEntryAdapter = extRepositoryFileEntryAdapter;
		_extRepositoryFileVersion = extRepositoryFileVersion;
	}

	@Override
	public String getChangeLog() {
		return _extRepositoryFileVersion.getChangeLog();
	}

	@Override
	public InputStream getContentStream(boolean incrementCounter)
		throws PortalException, SystemException {

		return getRepository().getContentStream(this);
	}

	@Override
	public String getExtension() {
		return _extRepositoryFileEntryAdapter.getExtension();
	}

	@Override
	public String getExtraSettings() {
		return null;
	}

	public ExtRepositoryFileVersion getExtRepositoryModel() {
		return _extRepositoryFileVersion;
	}

	@Override
	public FileEntry getFileEntry() throws PortalException, SystemException {
		return _extRepositoryFileEntryAdapter;
	}

	@Override
	public long getFileEntryId() {
		return _extRepositoryFileEntryAdapter.getFileEntryId();
	}

	@Override
	public long getFileVersionId() {
		return getPrimaryKey();
	}

	@Override
	public String getIcon() {
		return DLUtil.getFileIcon(getExtension());
	}

	@Override
	public String getMimeType() {
		return MimeTypesUtil.getContentType(getTitle());
	}

	@Override
	public Class<?> getModelClass() {
		return FileVersion.class;
	}

	@Override
	public Date getModifiedDate() {
		return getCreateDate();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(FileVersion.class);
	}

	@Override
	public int getStatus() {
		return 0;
	}

	@Override
	public long getStatusByUserId() {
		return 0;
	}

	@Override
	public String getStatusByUserName() {
		return null;
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return null;
	}

	@Override
	public Date getStatusDate() {
		return getCreateDate();
	}

	@Override
	public String getTitle() {
		return _extRepositoryFileEntryAdapter.getTitle();
	}

	@Override
	public String getVersion() {
		return _extRepositoryFileVersion.getVersion();
	}

	@Override
	public boolean isApproved() {
		return true;
	}

	@Override
	public boolean isDraft() {
		return false;
	}

	@Override
	public boolean isExpired() {
		return false;
	}

	@Override
	public boolean isPending() {
		return false;
	}

	private ExtRepositoryFileEntryAdapter _extRepositoryFileEntryAdapter;
	private ExtRepositoryFileVersion _extRepositoryFileVersion;

}