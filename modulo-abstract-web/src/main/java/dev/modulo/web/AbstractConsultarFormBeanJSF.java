package dev.modulo.web;

import java.io.Serializable;

import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;

import dev.modulo.service.exception.NegocioException;

public abstract class AbstractConsultarFormBeanJSF implements Serializable {

	private static final long serialVersionUID = 1L;

	private int currentPage;
	private Integer[] pages;
	private int rowsPerPage;
	private int firstRow;
	private int totalRows;
	private int totalPages;
	private int pageRange;

	protected void montarPaginacao() throws NegocioException {
		carregarLista();
		// Set currentPage, totalPages and pages.
        currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
        totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
        int pagesLength = Math.min(pageRange, totalPages);
        pages = new Integer[pagesLength];

        // firstPage must be greater than 0 and lesser than totalPages-pageLength.
        int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);

        // Create pages (page numbers for page links).
        for (int i = 0; i < pagesLength; i++) {
            pages[i] = ++firstPage;
        }
	}
	
	protected abstract void carregarLista();

	public void changePage(ActionEvent event) throws NegocioException {        
        page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
    }
	
	private void page(int firstRow) throws NegocioException {
        this.firstRow = firstRow;
        montarPaginacao();
    }
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Integer[] getPages() {
		return pages;
	}

	public void setPages(Integer[] pages) {
		this.pages = pages;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

}
