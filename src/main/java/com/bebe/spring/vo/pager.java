package com.bebe.spring.vo;

import org.springframework.stereotype.Repository;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;


@Data
@Repository
public class pager {


	private boolean prev;	
    private boolean next; 
    private int totalCount2; 
    private int totalCount; 
    private int startPage;
    private int endPage ;
    private int perPageNum =5;
    private Criteria cri;

	public void setCriteraia(Criteria cri) {
		this.cri =  cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		calcData();
	}
	private void calcData() {
			endPage= (int) (Math.ceil(cri.getPage()/(double)perPageNum)*perPageNum);
			startPage=(endPage -perPageNum) +1;
			
			int tempEndPage = (int)(Math.ceil(totalCount/(double) cri.getPerPageNum()));
			
			if(endPage>tempEndPage) {
				endPage=tempEndPage;
			}
			prev=startPage ==1 ? false : true;
			
			next = endPage * cri.getPerPageNum()>=totalCount? false:true;
	}
	public String makeQuery(int page, boolean needSearch) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
			.queryParam("page", page)
			.queryParam("perPageNum", this.cri.getPerPageNum());
		//검색 한 경우		
		if (this.cri.getKeyword() != null) {
			uriComponentsBuilder			
				.queryParam("keyword", this.cri.getKeyword());
		}
		return uriComponentsBuilder.build().encode().toString();
	}
	
}
