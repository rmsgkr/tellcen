package com.itcen.tellcen.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.datasource.lookup.SingleDataSourceLookup;

import lombok.Data;

@Data
public class PagingVO {
		
		private String petitionTitle, petitionArea, petitionField;
		private String complaintTitle, complaintOrganization, complaintOrganizationDetail;
		private String complaintSdate, complaintEdate;
		private String id, suggestionTitle, suggestionSdate, suggestionEdate;
		private int petitionStatus,complaintStatus, suggestionStatus, inquiryStatus;
		
		
		// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
		private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
		private int cntPage = 5;
		

		public PagingVO() {}
		
		// 리스트들의 공통 페이징
		public PagingVO(int total, int nowPage, int cntPerPage) {
			setNowPage(nowPage);
			setCntPerPage(cntPerPage);
			setTotal(total);
			calcLastPage(getTotal(), getCntPerPage());
			calcStartEndPage(getNowPage(), cntPage);
			calcStartEnd(getNowPage(), getCntPerPage());
		}
		
		// 상태별 페이징
		public PagingVO(int total, int nowPage, int cntPerPage, int petitionStatus, int complaintStatus, int suggestionStatus, int inquiryStatus) {
			setNowPage(nowPage);
			setCntPerPage(cntPerPage);
			setTotal(total);
			calcLastPage(getTotal(), getCntPerPage());
			calcStartEndPage(getNowPage(), cntPage);
			calcStartEnd(getNowPage(), getCntPerPage());
			setPetitionStatus(petitionStatus);
			setComplaintStatus(complaintStatus);
			setSuggestionStatus(suggestionStatus);
			setInquiryStatus(inquiryStatus);
		}
		// 청원 검색 페이징
		public PagingVO(int total, int nowPage, int cntPerPage, String petitionTitle, String petitionArea, String petitionField) {
			setNowPage(nowPage);
			setCntPerPage(cntPerPage);
			setTotal(total);
			calcLastPage(getTotal(), getCntPerPage());
			calcStartEndPage(getNowPage(), cntPage);
			calcStartEnd(getNowPage(), getCntPerPage());
			setPetitionTitle(petitionTitle);
			setPetitionArea(petitionArea);
			setPetitionField(petitionField);
		}
		
		
		// 민원 검색 페이징
		public PagingVO(int total, int nowPage, int cntPerPage, String complaintTitle, String complaintOrganization, String complaintOrganizationDetail, String complaintSdate, String complaintEdate) {
			setNowPage(nowPage);
			setCntPerPage(cntPerPage);
			setTotal(total);
			calcLastPage(getTotal(), getCntPerPage());
			calcStartEndPage(getNowPage(), cntPage);
			calcStartEnd(getNowPage(), getCntPerPage());
			setComplaintTitle(complaintTitle);
			setComplaintOrganization(complaintOrganization);
			setComplaintOrganizationDetail(complaintOrganizationDetail);
			setComplaintSdate(complaintSdate);
			setComplaintEdate(complaintEdate);
			
		}
		
		
		// 관리자 회원 or 제안 검색 페이징
		public PagingVO(int total, int nowPage, int cntPerPage, String id, String suggestionTitle, String suggestionSdate, String suggestionEdate) {
			setNowPage(nowPage);
			setCntPerPage(cntPerPage);
			setTotal(total);
			calcLastPage(getTotal(), getCntPerPage());
			calcStartEndPage(getNowPage(), cntPage);
			calcStartEnd(getNowPage(), getCntPerPage());
			setId(id);
			setSuggestionTitle(suggestionTitle);
			setSuggestionSdate(suggestionSdate);
			setSuggestionEdate(suggestionEdate);
		}
		
		// 제일 마지막 페이지 계산
		public void calcLastPage(int total, int cntPerPage) {
			setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
		}
		// 시작, 끝 페이지 계산
		public void calcStartEndPage(int nowPage, int cntPage) {
			setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
			if (getLastPage() < getEndPage()) {
				setEndPage(getLastPage());
			}
			setStartPage(getEndPage() - cntPage + 1);
			if (getStartPage() < 1) {
				setStartPage(1);
			}
		}
		// DB 쿼리에서 사용할 start, end값 계산
		public void calcStartEnd(int nowPage, int cntPerPage) {
			setEnd(nowPage * cntPerPage);
			setStart(getEnd() - cntPerPage + 1);
		}
}
