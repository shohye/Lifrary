package ksmart.pentagon.librarianbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart.pentagon.vo.LibrarianBook;

@Controller
public class LibrarianBookController {

	@Autowired private LibrarianBookService librarianBookService;
		
		@GetMapping("/admin/bookRecommendList")
		public String adminBookRecommendList(LibrarianBook librarianBook,Model model,HttpSession session) {
			librarianBook.setlCode((String)session.getAttribute("LIBNUM"));
			System.out.println(librarianBook.getlCode());
			List<LibrarianBook> lbL = librarianBookService.librarianBookList(librarianBook);
			System.out.println("LibrarianBookController24" + lbL);
			return "adminpage/board/bookRecommendList";
		}
		
}