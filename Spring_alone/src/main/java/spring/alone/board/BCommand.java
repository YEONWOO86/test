package spring.alone.board;

import org.springframework.ui.Model;

public interface BCommand {
	
	void execute(Model model);
	
}