package com.joantolos.utils.exception;

import com.joantolos.utils.enums.FileErrorCode;

public class FileManipulationException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorParameter = null;
	private FileErrorCode errorCode = FileErrorCode.OK;
	
	public FileManipulationException() {
		
	}
	
	public FileManipulationException(String message) {
		super(message);
	
	}
	public FileManipulationException(FileErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public FileManipulationException(FileErrorCode errorCode, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
	}
		
	public FileErrorCode getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(FileErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public String errorMessage() {
		switch (errorCode) {
			case OK:
				return "TILT: Should not get here.";
            case CLOSING_BUFFERED_READER_ERROR:
                return "Could not close the buffered reader";
            case CLOSING_INPUT_STREAM_ERROR:
                return "Could not close the input stream";
            case FILE_ARRAY_BYTES_NULL:
                return "No array bytes founded";
			case UNMARSHALLING_FILE_ERROR:
				return "Error unmarshalling file: "+this.errorParameter;
			case STRING_FROM_STREAM_ERROR:
				return "Error transforming stream to string";
			case WRITING_FILE_ERROR:
				return "Error writing file: "+this.errorParameter;
			case DELETING_FILE_ERROR:
				return "Error deleting file: "+this.errorParameter;
		}
		return "";
	}
}

