package test;

	import java.time.LocalDate;

	import java.util.Date;
	public class Borrow {
		private int borrowid;
		private int  userid;
		private int bookid;
		private Date bdate;
	    private LocalDate rdate;
		public int getBorrowid() {
			return borrowid;
		}
		public void setBorrowid(int borrowid) {
			this.borrowid = borrowid;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public Date getBdate() {
			return bdate;
		}
		public void setBdate(Date bdate) {
			this.bdate = bdate;
		}
		
		
		public LocalDate getRdate() {
			return rdate;
		}
		public void setRdate(LocalDate rdate) {
			this.rdate = rdate;
		}
	}

