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
			System.out.println(librarianBook.getlCode());
			List<LibrarianBook> lbl = librarianBookService.librarianBookList(librarianBook);
			System.out.println("LibrarianBookController25" + lbl);
			model.addAttribute("lbl", lbl);
			return "/adminpage/board/bookRecommendList";
		}
		
		@GetMapping("admin/bookRecommendDetail")
		public String bookRecommend(LibrarianBook librarianBook , Model model) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("LibrarianBookController클레스 bookRecommend 메서드 실행");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@");
			LibrarianBook Llist = librarianBookService.librarianBookDetail(librarianBook);
			System.out.println("LibrarianBookController36"+Llist);
			model.addAttribute("Llist", Llist);
			return "/adminpage/board/bookRecommendDetail";
		}
		
		@GetMapping("/admin/bookRecommendDelete")
		public String bookRecommendDelete(@RequestParam(value = "lbCode")String lbCode) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("LibrarianBookController클레스 bookRecommendDelete 메서드 실행");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("LibrarianBookController46" + lbCode );
			librarianBookService.bookRecommendDelete(lbCode);
			return "redirect:/admin/bookRecommendList";
		}
		
		@GetMapping("/admin/bookRecommendInsert")
		public String bookRecommendInsert() {
			return "/adminpage/board/bookRecommendInsert";
		}
		
		@PostMapping("/admin/bookRecommendInsert")
		public @ResponseBody BookInformation bookRecommendInsert(@RequestParam(value = "isbnVal")String isbnVal) {
			System.out.println("LibrarianBookController클래스 bookRecommendInsert메서드 실행");
			System.out.println("LibrarianBookController61"+isbnVal);
			BookInformation bookInformation = librarianBookService.getBookInformation(isbnVal);
			System.out.println("LibrarianBookController65" + bookInformation);
			return bookInformation;
		}
		@PostMapping("/testVal")
		public @ResponseBody String test11(@RequestParam(value = "textVal")String textVal) {
			System.out.println("11111111111111111111"+textVal);
			return textVal;
		}
		
}