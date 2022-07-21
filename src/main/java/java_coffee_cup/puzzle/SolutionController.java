package java_coffee_cup.puzzle;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolutionController {
	private final SolutionRepository repo;

	public SolutionController(SolutionRepository repo) {
		this.repo = repo;
	}

	@PostMapping("/rectangle_partition")
	String getRectangle_partitionResult(@RequestBody String input) {
		return java_coffee_cup.puzzle.rectanglePartition.Puzzle.solve(input) + "\n";
	}

	@PostMapping("/rectanglePartition")
	String getRectanglePartitionResult(@RequestBody String input) {
		return java_coffee_cup.puzzle.rectanglePartition.Puzzle.solve(input) + "\n";
	}

	@PostMapping("/thomas")
	String getThomasResult(@RequestBody String input) {
		return java_coffee_cup.puzzle.thomas.Puzzle.solve(input) + "\n";
	}

	@PostMapping("/graffiti")
	String getGraffiti(@RequestBody String input) {
		return java_coffee_cup.puzzle.graffiti.Puzzle.solve(input);
	}

	@PostMapping("/lightBulbs")
	String getLightBulbs(@RequestBody String input) {
		return java_coffee_cup.puzzle.lightBulbs.Puzzle.solve(input);
	}

	@PostMapping("/asciiArt")
	String getAsciiArt(@RequestBody String input) {
		return java_coffee_cup.puzzle.asciiArt.Puzzle.solve(input);
	}

	@PostMapping("/magicString")
	String getMagicString(@RequestBody String input) {
		return java_coffee_cup.puzzle.magicString.Puzzle.solve(input);
	}

	@PostMapping("/asteriods")
	String getAsteriods(@RequestBody String input) {
		return java_coffee_cup.puzzle.asteriods.Puzzle.solve(input);
	}

	@PostMapping("/remainder")
	String getRemainder(@RequestBody String input) {
		return java_coffee_cup.puzzle.remainder.Puzzle.solve(input);
	}

	@PostMapping("/unitFraction")
	String getUnitFraction(@RequestBody String input) {
		return java_coffee_cup.puzzle.unitFraction.Puzzle.solve(input);
	}
}
