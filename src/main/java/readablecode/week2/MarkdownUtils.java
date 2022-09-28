package readablecode.week2;

import java.util.List;

public class MarkdownUtils {

	public static String createTables(List<String> stringsList, int maxCount) throws IllegalArgumentException {
		//引数の例外パターンと処理
		if (stringsList == null || stringsList.isEmpty()) {
			throw new IllegalArgumentException("");
		}
		if (maxCount < 1) {
			throw new IllegalArgumentException("");
		}

		//文字と文字の間を"｜"で連結して出力
		StringBuilder markdownSeat = new StringBuilder();
		for (String e : stringsList) {
			markdownSeat.append("|");
			markdownSeat.append(e);
		}
		markdownSeat.append("|");
		markdownSeat.append(System.lineSeparator());

		//文字と文字の間を"－"で連結して出力
		for (String e : stringsList) {
			markdownSeat.append("|");
			for (int i = 0; i < e.length(); i++) {
				markdownSeat.append("-");
			}
		}
		markdownSeat.append("|");
		markdownSeat.append(System.lineSeparator());

		//文字列を空文字で連結し出力
		for (int i = 0; i < maxCount; i++) {
			for (String e : stringsList) {
				markdownSeat.append("|");
				for (int j = 0; j < e.length(); j++) {
					markdownSeat.append(" ");
				}
			}
			markdownSeat.append("|");
			markdownSeat.append(System.lineSeparator());
		}
		return markdownSeat.toString();
	}

}
