package fr.insee.aoc.days;

import org.junit.Assert;
import org.junit.Test;

public class Day08Test {

	private Day day = new Day08();

	@Test
	public void case1_0() {
		Assert.assertEquals(day.part1("./src/main/resources/day8",25,6), "828");
	}

}
