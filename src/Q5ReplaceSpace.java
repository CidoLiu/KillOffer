/**
 * @author liudongjin
 * @date 2021/3/18 23:33
 * @description 将字符串中的空格替换为%20，P51
 */
public class Q5ReplaceSpace {

    public static void main(String[] args) {
        String s = "Q 123 ";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return new String();
        }
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
