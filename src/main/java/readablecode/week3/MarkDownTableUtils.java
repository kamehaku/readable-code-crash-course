package readablecode.week3;

import java.util.List;
import java.util.Objects;

public class MarkDownTableUtils {
	// TODO8 : search DRY and OAOO on internet and find the code to use same method which you use

	// TODO9 : remove the comment and extract method to reduce the code steps in this method: should be less than 15 lines - readable code 11.4

	// TODO10 : refactor the extracted method by removing StringBuilder Argument and return String
	// https://cyzennt.co.jp/blog/2021/05/19/java%EF%BC%9A%E5%BC%95%E6%95%B0%E3%81%A7%E6%B8%A1%E3%81%97%E3%81%9F%E5%8F%82%E7%85%A7%E5%9E%8B%E5%A4%89%E6%95%B0%E3%82%92%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E5%86%85%E3%81%A7%E5%A4%89%E6%9B%B4/

	// TODO11 : find more repeated code and refactor them hint:|caption1|caption2|
	// you might need to create the method to create List which has caption for separator or brank column

	// TODO6 : add @throws in following javadoc 
	/** 
	 * Returns the string of table which has empty rows as Markdown table syntax.
	 * For example, returns following if headerRowCaptions is [Name,Quantity] and emptyRowCount is 2
	 * |Name|Quantity|
	 * |----|--------|
	 * |    |        |
	 * |    |        | 
	 * length of each caption for separator and empty cell is same with each header caption as above
	 * 
	 * @param headerRowCaptions  the captions for header row
	 * @param emptyRowCount  the number of empty rows.
	 * @return the string of table which has empty rows as Markdown table syntax.
	 * 
	 */
	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {
		// validate args
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}

		StringBuilder markdownTable = new StringBuilder();
		// create line for header row captions
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			markdownTable.append(e);
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create line for header row separator
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			// TODO7 : use com.google.common.base.Strings to replace your code : readable
			// code 12.2 13.4
			// https://guava.dev/releases/19.0/api/docs/com/google/common/base/Strings.html
			for (int i = 0; i < e.length(); i++) {
				markdownTable.append("-");
			}
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create lines for empty rows
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerRowCaptions) {
				markdownTable.append("|");
				for (int j = 0; j < e.length(); j++) {
					markdownTable.append(" ");
				}
			}
			markdownTable.append("|");
			markdownTable.append(System.lineSeparator());
		}

		return markdownTable.toString();

	}

}
