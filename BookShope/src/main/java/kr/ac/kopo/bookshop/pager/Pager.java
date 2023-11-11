package kr.ac.kopo.bookshop.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	
	private int page = 1; //값을 아무것도 안가져왔을때 -> 기본값 1
	private int perPage = 10; //페이지당 보여줄 갯수
	private float total;
	private int perGroup = 5;
	
	private int search;
	
	private String keyword;
	//주로 검색할 키워드나 검색어를 저장하는 용도로 활용될 것으로 보입니다.
	
	//시작 위치(offset)를 계산하는 메서드
	public int getOffset() {
		return perPage * (page -1);
	}
	
	
	public String getQuery() {
// 메서드는 검색 기능을 위해 URL에 쿼리 문자열(query string)을 생성하는 메서드		
		String queryString = "";// 빈 문자열을 초기화합니다
	
		if(search > 0)//조건을 사용하여 search 값이 0보다 큰지 검사 이 조건은 검색을 수행하는 경우에만 실행
			queryString += "&search=" + search + "&keyword=" + keyword;
//queryString += ...: queryString 변수는 쿼리 문자열을 저장하는 문자열입니다. += 연산자는 문자열을 연결(이어붙이기)하는 역할 여기서 queryString에 새로운 정보를 덧붙입니다.
//"&search=": 이 부분은 URL 쿼리 문자열의 일부로서, "search" 매개변수를 나타냄 "search"는 아마도 검색 조건을 나타내는 변수
//+ search: search 변수의 값을 문자열로 변환하여 URL 쿼리 문자열에 추가합니다. search 변수는 검색 조건을 나타내며, 이 값이 URL에 추가
//"&keyword=": 이 부분은 다시 한 번 URL 쿼리 문자열의 일부로서, "keyword" 매개변수를 나타냅니다. "keyword"는 검색어를 나타내는 변수
//+ keyword: keyword 변수의 값을 문자열로 변환하여 URL 쿼리 문자열에 추가합니다. keyword 변수는 검색어를 나타내며, 이 값이 URL에 추가		
		return queryString;
	}
	
	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public String getKeyword() {//검색어를 반환하는 메서드
		if(search < 1)
			keyword = "";
//변수를 검사하여 검색 항목이 1 미만일 때 (즉, 선택한 항목이 없을 때) 검색어를 빈 문자열("")로 설정
//사용자가 검색 항목을 선택하지 않거나 선택 후 검색어를 입력하지 않은 경우, 이 메서드는 검색어를 빈 문자열("")로 설정		
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getPerGroup() {
		return perGroup;
	}
	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}

	public int getLast() {
		return (int) Math.ceil(total / perPage);
		//getLast 메서드는 전체 항목 수 total을 한 페이지당 보여줄 항목 수 perPage로 나눈 결과를 올림하여 마지막 페이지 번호를 반환	
	}
	
	public int getPrev() {
		return page ==1 ? 1 : page -1;
//		page 값이 1인 경우, 현재 페이지가 첫 번째 페이지이므로 1을 반환하여 더 이전 페이지가 없음을 나타냅니다.
//		그렇지 않은 경우, page에서 1을 뺀 값을 반환하여 현재 페이지의 바로 이전 페이지 번호를 나타냅니다.
//		이렇게 하면 사용자가 현재 페이지에서 "이전"을 클릭할 때, 첫 번째 페이지 이외의 모든 페이지에서는 이전 페이지로 이동할 수 있도록 합니다.
	}
	

	public int getNext() {
		return page == getLast() ? getLast() : page +1;
//page 값이 마지막 페이지 번호인 getLast()와 같은 경우, 현재 페이지가 이미 마지막 페이지이므로 getLast()를 반환하여 더 이상 다음 페이지로 이동할 수 없음을 나타냄
//그렇지 않은 경우, page에서 1을 더한 값을 반환하여 현재 페이지의 다음 페이지 번호를 나타냅니다.
//이렇게 하면 사용자가 현재 페이지에서 "다음"을 클릭할 때, 마지막 페이지 이외의 모든 페이지에서는 다음 페이지로 이동할 수 있도록 합니다.
	}

	
	public List<Integer> getList(){
		List<Integer> list = new ArrayList<Integer>();
		
		int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1;;
		
		for(int i = startPage; i < (startPage + perGroup)&& i <= getLast();  i++)
            list.add(i);	
		
		if(list.isEmpty())
			list.add(1);
		
		return list;
	}
//	List<Integer> list = new ArrayList<Integer>();: 정수형 데이터를 저장하는 ArrayList 객체를 생성하여 페이지 번호 목록을 저장할 준비를 합니다.
//	int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1;: 현재 페이지(page)를 기반으로 시작 페이지 번호(startPage)를 계산합니다. 계산식은 다음과 같습니다:
//	먼저, 현재 페이지에서 1을 뺀 후 페이지 그룹 당 페이지 수(perGroup)로 나눕니다. 이렇게 하면 현재 페이지가 속한 페이지 그룹의 인덱스를 얻습니다.
//	그 다음, 이 값을 0을 더하고, 페이지 그룹 당 페이지 수(perGroup)를 곱합니다. 이렇게 하면 현재 페이지가 속한 페이지 그룹의 첫 번째 페이지 번호를 얻습니다.
//	마지막으로, 1을 더하여 페이지 그룹의 첫 번째 페이지 번호로 설정합니다.
//	for(int i = startPage; i < (startPage + perGroup) && i <= getLast(); i++): 시작 페이지 번호부터 시작하여 페이지 그룹 당 페이지 수(perGroup)만큼 반복합니다. 그리고 getLast() 메서드를 호출하여 마지막 페이지 번호를 얻고, 이를 초과하지 않는 범위에서 반복합니다.
//	list.add(i);: 반복문에서 얻은 페이지 번호(i)를 목록(list)에 추가합니다.
//	if(list.isEmpty()) list.add(1);: 만약 목록이 비어있다면, 기본적으로 1 페이지를 추가합니다. 이는 페이지 목록이 없는 경우에 기본적으로 첫 번째 페이지를 보여주기 위한 처리입니다.
//	마지막으로 페이지 번호 목록(list)을 반환합니다.
//	이렇게 하면 현재 페이지 그룹에 해당하는 페이지 번호 목록을 가져와서 리스트로 반환하게 됩니다.	
	
	
	
}






























