import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int PER_PAGE = 5; // 한 페이지당 글 수
        int currentPage = 1;    // 현재 페이지
        boolean isSearching = false; // 검색 중 여부
        String searchKeyword = "";   // 검색어

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/board", "your_user", "your_password");
            Statement st = con.createStatement();

            while (true) {
                int startIndex = (currentPage - 1) * PER_PAGE;
                String sql;

                if (isSearching) {
                    sql = "SELECT * FROM board WHERE b_title LIKE '%" + searchKeyword + "%' " +
                          "ORDER BY b_no DESC LIMIT " + startIndex + ", " + PER_PAGE;
                } else {
                    sql = "SELECT * FROM board ORDER BY b_no DESC LIMIT " + startIndex + ", " + PER_PAGE;
                }

                ResultSet rs = st.executeQuery(sql);

                System.out.println("===== " + (isSearching ? ("검색결과: " + searchKeyword) : "전체목록") + " (" + currentPage + "페이지) =====");
                boolean hasData = false;
                while (rs.next()) {
                    int no = rs.getInt("b_no");
                    String title = rs.getString("b_title");
                    System.out.println(no + ": " + title);
                    hasData = true;
                }
                if (!hasData) {
                    System.out.println("글이 없습니다.");
                }
                System.out.println("==========================");

                System.out.println("[n]ext [p]revious [s]earch [a]ll [e]xit [번호입력=상세보기]");
                String cmd = sc.next();

                if (cmd.equals("n")) {
                    currentPage++;
                } else if (cmd.equals("p")) {
                    if (currentPage > 1) {
                        currentPage--;
                    } else {
                        System.out.println("첫 페이지입니다.");
                    }
                } else if (cmd.equals("s")) {
                    System.out.print("검색할 제목 키워드 입력: ");
                    searchKeyword = sc.next();
                    isSearching = true;
                    currentPage = 1;
                } else if (cmd.equals("a")) {
                    isSearching = false;
                    currentPage = 1;
                } else if (cmd.equals("e")) {
                    System.out.println("프로그램 종료.");
                    break;
                } else {
                    try {
                        int postNo = Integer.parseInt(cmd); // 번호 입력한 경우
                        showDetail(con, postNo);            // 상세보기 실행
                    } catch (NumberFormatException ex) {
                        System.out.println("올바른 명령어를 입력하세요.");
                    }
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 📌 글 상세보기 함수
    static void showDetail(Connection con, int postNo) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM board WHERE b_no = " + postNo;
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("===== 글 상세보기 =====");
                System.out.println("글번호: " + rs.getInt("b_no"));
                System.out.println("제목: " + rs.getString("b_title"));
                System.out.println("작성자: " + rs.getString("b_id"));
                System.out.println("작성시간: " + rs.getString("b_datetime"));
                System.out.println("본문: " + rs.getString("b_text"));
                System.out.println("======================");
            } else {
                System.out.println("해당 글을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}