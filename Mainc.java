import java.util.Scanner;
public class Mainc {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String y = x.nextLine();
        if (y.contains("+")) {
            int f = y.indexOf("+");
            String r = y.substring(0, f);
            String n = y.substring(f);
            n = n.replace("+", " ");
            String h = (r + n).replaceAll("\"", "");
            h = h.replace(" ", "");
            if (y.contains("+")) {
                System.out.print("\"" + h + "\"");
            }
        }
        if (y.contains("*")) {
            int f = y.indexOf("*");
            String r = y.substring(0, f);
            String n = y.substring(f);
            n = n.replace("*", " ");
            for (int b = 0; b < n.length(); b++) {
                char currentChar = n.charAt(b);
                if (Character.isDigit(currentChar)) {
                    int j = Character.getNumericValue(currentChar);

                    String h = r.repeat(j);
                    h = h.replaceAll("\"", "");
                    h = h.replace(" ", "");
                    if (y.contains("*")) {
                        System.out.print("\"" + h + "\"");
                    }
                }
            }
        }
        if (y.contains("/")) {
            int f = y.indexOf("/");
            String r = y.substring(0, f);
            String l = r.replaceAll("\"", "");
            String n = y.substring(f);
            n = n.replace("/", " ");
            for (int b = 0; b < n.length(); b++) {
                char currentChar = n.charAt(b);
                if (Character.isDigit(currentChar)) {
                    int j = Character.getNumericValue(currentChar);

                    String h = l.substring(0, Math.min(j, r.length()));
                    h = h.replace(" ", "");
                    if (y.contains("/")) {
                        System.out.print("\"" + h + "\"");
                    }
                }
            }
        }
        if (y.contains("-")) {
            String h = y.replaceFirst("-", "+");
            if (h.contains("-")) {
                h = h.replaceAll("\"", "");
                int f = h.indexOf("+");
                int j = h.indexOf("-");
                String r = h.substring(0, j);
                String o = r.substring(0, f);
                String w = r.substring(f);
                w = w.replace("+", "");
                w = w.replace(" ", "");
                String n = h.substring(j);
                String k = n.replace("-", "");
                k = k.replace(" ", "");
                //System.out.print(k);
                if ((k.equals(w))) {
                    System.out.print("\"" + o + "\"");
                } else
                    System.out.print("\"" + (o + "-" + w) + "\"");
                //} else
                //System.out.print("\"" + r + "\"");
                //}else
            }else {
                y = y.replaceAll("\"", "");
                //System.out.print(h);
                int f = y.indexOf("-");
                int j = y.indexOf(" ");
                String r = y.substring(0, f);
                String o = r.substring(0, j);
                String u = r.substring(j,f);
                u = u.replace(" ", "");
                String w = y.substring(f);
                w = w.replace("-", "");
                w = w.replace(" ", "");
                //System.out.print(w);
                if ((u.equals(w))) {
                    System.out.print("\"" + o + "\"");
                }else
                    System.out.print("\"" + (o + " " + u) + "\"");
            }
        }
    }
}







