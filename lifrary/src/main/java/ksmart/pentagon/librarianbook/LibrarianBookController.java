package ksmart.pentagon.librarianbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.LibrarianBook;

@Controller
public class LibrarianBookController {

	@Autowired private LibrarianBookService librarianBookService;
		
		@GetMapping("/admin/bookRecommendList")
		public String adminBookRecommendList(LibrarianBook librarianBook,Model model,HttpSession session) {
			librarianBook.setlCode((String)session.getAttribute("LIBNUM"));
			List<LibrarianBook> lbl = librarianBookService.librarianBookList(librarianBook);
			model.addAttribute("lbl", lbl);
			return "/adminpage/board/bookRecommendList";
		}
		
		@GetMapping("/admin/bookRecommendDetail")
		public String bookRecommend(LibrarianBook librarianBook , Model model) {
			LibrarianBook Llist = librarianBookService.librarianBookDetail(librarianBook);
			model.addAttribute("Llist", Llist);
			return "/adminpage/board/bookRecommendDetail";
		}
		
		@GetMapping("/admin/bookRecommendDelete")
		public String bookRecommendDelete(@RequestParam(value = "lbCode")String lbCode) {
			librarianBookService.bookRecommendDelete(lbCode);
			return "redirect:/admin/bookRecommendList";
		}
		
		@GetMapping("/admin/bookRecommendInsert")
		public String bookRecommendInsert() {
			return "/adminpage/board/bookRecommendInsert";
		}
		
		@PostMapping("/admin/bookRecommendIsbn")
		public @ResponseBody BookInformation bookRecommendIsbn(@RequestParam(value = "isbnVal")String isbnVal) {
			BookInformation bookInformation = librarianBookService.getBookInformation(isbnVal);
			if(bookInformation == null) {
				BookInformation bookInformationNull = new BookInformation();
				return bookInformationNull;
			}else {
				return bookInformation;
			}
			
		}
		
//		추천도서 등록
		@PostMapping("/admin/bookRecommendInsert")
		public String bookRecommendInsert(LibrarianBook librarianBook , @RequestParam(value = "isbn")String isbn,HttpSession httpSession) {
			librarianBook.setlCode((String)httpSession.getAttribute("LIBNUM"));
			librarianBook.setuId((String)httpSession.getAttribute("SAID"));
			String relbCode = librarianBookService.bookRecommendInsert(librarianBook,isbn);
			
			return "redirect:/admin/bookRecommendDetail?lbCode="+relbCode;
		}
		
		@GetMapping("/admin/bookRecommendUpdate")
		public String bookRecommendUpdate(LibrarianBook librarianBook , Model model) {
			LibrarianBook Llist = librarianBookService.librarianBookDetail(librarianBook);
			model.addAttribute("Llist", Llist);
			return "/adminpage/board/bookRecommendUpdate";
		}
		
		@PostMapping("/admin/bookRecommendUpdate")
		public String bookRecommendUpdate(LibrarianBook librarianBook) {
			librarianBookService.bookRecommendUpdate(librarianBook);
			String lbCode = librarianBook.getLbCode();
			return "redirect:/admin/bookRecommendDetail?lbCode="+lbCode;
		}
		
		
}