import java.util.HashSet;
import java.util.Set;

public class ParenthesisPairs {

    /**
     * @param pairCount - number of pairs of parenthesis to combine
     * @return - Set of combinations of parenthesis strings with n valid pairs
     */
    public static Set<String> getPairCombinations(Integer pairCount) {
        Set <String> result = new HashSet<>();
        if (pairCount == 0) {
            return result;
        }
        for (int i = 0; i < pairCount; i++) {
            result = addParenPair(result);
        }
        return result;
    }

    /**
     * @param set - set of combinations of parenthesis strings with n valid pairs
     * @return - set of combinations of parenthesis strings with n+1 valid pairs
     */
    public static Set<String> addParenPair(Set<String> set) {
        Set<String> result = new HashSet();
        if (set.isEmpty()) {
            result.add("()");
            return result;
        }

        for (String s: set) {
           for (int j = 0; j <= s.length(); j++)  {
               result.add(surroundChar(s, j));
           }
        }
        return result;
    }

    /**
     * @param str - string of character input
     * @param index - character index to surround with ()'s
     * @return string - with indexed character surrounded by parantheses : str[0->index] + "(" + str[index] + ")" + str[index->eol]
     */
    public static String surroundChar(String str, Integer index) {
        if (str == null || str.isEmpty()) {
            return "()";
        }

        if (index >= str.length()) {
            return str + "()";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)  {
            if (i == index) {
                sb.append("(" + str.charAt(i) + ")");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int numPairs=0; numPairs < 5; numPairs++) {
            System.out.println("n = " + numPairs + " " + ParenthesisPairs.getPairCombinations(numPairs));
        }
        /* Yields:
        n = 0 []
        n = 1 [()]
        n = 2 [()(), (())]
        n = 3 [()()(), ()(()), (()()), (())(), ((()))]
        n = 4 [()()()(), (()(())), (()())(), ()()(()), (())()(), (((()))), (())(()), ()((())), ()(())(), ()(()()), (()()()), ((()())), ((()))(), ((())())]
        */
    }
}
