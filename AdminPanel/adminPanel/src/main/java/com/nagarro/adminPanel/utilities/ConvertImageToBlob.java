package com.nagarro.adminPanel.utilities;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ConvertImageToBlob {

	public static Blob convertImageToBlob(CommonsMultipartFile idProof) {
		byte[] idProofContent = idProof.getBytes();
		Blob idProofBlob = null;
		try {
			idProofBlob = new SerialBlob(idProofContent);
		} catch (SerialException e) {
//			LOG.error("SerialException : ", e);
		} catch (SQLException e) {
//			LOG.error("SQLException : ", e);
		}
		
		return idProofBlob;
	}
}
