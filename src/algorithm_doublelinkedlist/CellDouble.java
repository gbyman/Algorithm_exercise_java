package algorithm_doublelinkedlist;
// 이중 연결 리스트의 셀
public class CellDouble {
	
	CellDouble prev;	//이전 셀로의 링크
	CellDouble next;	//다음 셀로의 링크
	Object data;	//이 셀의 데이터
	
//	셀을 생성한다
//	
//	@param aData 이 셀의 데이터
	CellDouble(Object aData){
		
		prev = next = null;
		data = aData;
	}
}
