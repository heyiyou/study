package com.peisia.jsp.board.dao;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.peisia.db.Dao;
import com.peisia.db.Db;
import com.peisia.jsp.board.Board;
import com.peisia.jsp.board.dto.Dto;
public class DaoBoard extends Dao{
	/* (1/5)삭제 */
	public void del(String no) {
		super.connect();	//conect()라고 해도 됨.	//[고정1,2,3]
//		connect();
		String sql = String.format("delete from %s where b_no=%s"
				,Board.TABLE_PS_BOARD_FREE, no);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* (2/5)쓰기 */
	public void insert(Dto d) {
		super.connect();	//[고정1,2,3]
		String sql = String.format(
				"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s')"
				,Board.TABLE_PS_BOARD_FREE, d.title,d.id,d.text);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* (3/5)글 읽기 */
	public Dto selectPost(String no) {
		super.connect();	//[고정1,2,3]
		Dto post = null;
		try {
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select * from %s where b_no=%s"
					,Board.TABLE_PS_BOARD_FREE, no);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return post;
	}	
	/* (4/5)글 리스트 */
	public ArrayList<Dto> selectListBackup(String page) {
		super.connect();	//[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<>();
		try {

			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
//			select * from board order by b_no desc limit 20,5;
			String sql = String.format(
					"select * from %s limit %s,%s"
					,Board.TABLE_PS_BOARD_FREE,startIndex,Board.LIST_AMOUNT);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return posts;
	}
	public ArrayList<Dto> selectList(int startIndex) {
		super.connect();	//[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format(
					"select * from %s limit %d,%d"
					,Board.TABLE_PS_BOARD_FREE
					,startIndex
					,Board.LIST_AMOUNT);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return posts;
	}
	/* (5/5)수정 */
	public void update(Dto d,String no) {
		super.connect();	//[고정1,2,3]
		String sql = String.format(
				"update %s set b_title='%s',b_text='%s' where b_no=%s"
				,Board.TABLE_PS_BOARD_FREE, d.title,d.text,no);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* 총 글 수 구하기 */
	public int selectPostCount() {
		int count = 0;
		super.connect();	//[고정1,2,3]
		try {
			String sql = String.format(
					"select count(*) from %s"
					,Board.TABLE_PS_BOARD_FREE);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}
	/* 총 글 수 구하기 */
	public int selectSearchPostCount(String word) {
		int count = 0;
		super.connect();	//[고정1,2,3]
		try {
			String sql = String.format(
					"select count(*) from %s where b_title like '%%%s%%'"
					,Board.TABLE_PS_BOARD_FREE,word);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}	
	/* 글 리스트<검색> */
	public ArrayList<Dto> selectlistSearch(String word,String page) {
		super.connect();	//[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<>();
		try {

			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_title like '%1%';
			String sql = String.format(
					"select * from %s where b_title like '%%%s%%' limit %s,%s"
					,Board.TABLE_PS_BOARD_FREE,word,startIndex,Board.LIST_AMOUNT);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return posts;
	}	
	
	public ArrayList<Dto> list(String pageNum) {
		return selectListBackup(pageNum);  // 또는 selectList(Integer.parseInt(pageNum));
	}

	public int getPageCount() {
		return (int)Math.ceil((double)selectPostCount() / Board.LIST_AMOUNT);
	}
}