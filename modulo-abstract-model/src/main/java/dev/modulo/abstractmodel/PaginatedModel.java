package dev.modulo.abstractmodel;

public class PaginatedModel extends RequestModel {
	
	private static final long serialVersionUID = 1L;
	
	private Integer startPosition, maxResult;
	
	public PaginatedModel() {
		
	}

	public Integer getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Integer startPosition) {
		this.startPosition = startPosition;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	

}
