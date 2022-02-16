package com.Library.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Book {
	    
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	    @Column
	    @NotEmpty
	    @Size(min=2,message="atleast 2 character")
	    
	    private String bookName;
	    @Column
	    @NotEmpty
	    @Size(min=2,message="atleast 2 character")
	 
	    private String authorName;
	    
		 Book()
		{
			
		}
		 
		 public Book(@NotEmpty @Size(min = 2, message = "atleast 2 character") String authorname,
				 @NotEmpty @Size(min = 8, message = "must be atleast 8 characters") String bookname)
				 {
				 super();
				 this.authorName = authorname;
				 this.bookName = bookname;
				 
				 }
		
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
	    
	    

}
