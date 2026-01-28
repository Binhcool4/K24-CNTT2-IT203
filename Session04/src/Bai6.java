import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {
        String[] reviews = {
                "Cuốn sách này rất ngu ngốc, nội dung thật ngu ngốc và không đáng đọc.",
                "Sách hay lắm, nội dung rất hay và đáng đọc.",
                "Cuốn sách này rất dở tệ, nội dung ngu ngốc, vớ vẩn, dở ẹc, không nên mua.",
                "Một cuốn sách bình thường thôi."
        };
        for (String review : reviews) {
            String daXuLy = xuLyReview(review);
            System.out.println("Review gốc:");
            System.out.println(review);
            System.out.println("Review sau khi xử lý:");
            System.out.println(daXuLy);
            System.out.println("─".repeat(60));
        }
    }

    public static String xuLyReview(String review) {
        if (review == null || review.trim().isEmpty()) {
            return review;
        }
        String[] blacklist = {
                "ngu", "ngu ngốc", "dở", "dở tệ", "vớ vẩn", "đần", "đần độn", "tệ", "rác"
        };
        String result = review;
        for (String tuCam : blacklist) {
            String regex = "(?i)\\b" + Pattern.quote(tuCam) + "\\b";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher m = p.matcher(result);
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                String stars = "*".repeat(m.group().length());
                m.appendReplacement(sb, stars);
            }
            m.appendTail(sb);
            result = sb.toString();
        }
        if (result.length() > 200) {
            StringBuilder sb = new StringBuilder();
            int gioiHan = 200;
            int catTai = result.lastIndexOf(' ', gioiHan);
            if (catTai == -1) {
                catTai = gioiHan;
            }
            sb.append(result.substring(0, catTai));
            sb.append("...");
            result = sb.toString();
        }
        return result.trim();
    }
}
