import java.util.Scanner;
public class Mainc {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String y = x.nextLine();
        if (y.contains("+")) {
            int f = y.indexOf("+");
            String r = y.substring(0, f);
            String l = r.replaceAll("\"", "");
            l.replaceAll(" ", "");
            try {
                char g = l.charAt(0);
                String b = new String(new char[]{g});
                int m = (Integer.parseInt(b));
                System.out.print("\"" + "Неправильный ввод" + "\"");

            } catch (NumberFormatException e) {
                String n = y.substring(f);
                if (n.contains("\"")) {
                    n = n.replace("+", " ");
                    n = n.replace(" ", "");
                    n = n.replaceAll("\"", "");
                    r = r.replaceAll("\"", "");
                    System.out.print("\"" + (r + n) + "\"");
                }else{
                    System.out.print("\"" + "Неправильный ввод" + "\"");
                }
            }
        }
        if (y.contains("*")) {
            int f = y.indexOf("*");
            String r = y.substring(0, f);
            String l = r.replaceAll("\"", "");
            l.replaceAll(" ", "");
            String n = y.substring(f);
            n = n.replace("*", " ");
            n = n.replace(" ", "");
            try {
                char g = l.charAt(0);
                String b = new String(new char[]{g});
                int m = (Integer.parseInt(b));
                System.out.print("\"" + "Неправильный ввод" + "\"");

            } catch (NumberFormatException e) {
                //System.out.print(n);
                try {
                    int s = Integer.parseInt(n);
                    n = n.replace(" ", "");
                    n = n.replaceAll("\"", "");
                    r = r.replaceAll("\"", "");
                    int p = Integer.parseInt(n);
                    if (p != 0) {
                        System.out.print("\"" + r.repeat(p) + "\"");}
                    else
                        System.out.print("\"" + "Y" + "\"");
                }catch (NumberFormatException h){
                    System.out.print("\"" + "Неправильный ввод" + "\"");
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
            } else {
                y = y.replaceAll("\"", "");
                //System.out.print(h);
                int f = y.indexOf("-");
                String r = y.substring(0, f);
                String u = y.substring(f);
                u = u.replace("-", "");
                u = u.replace(" ", "");
                //System.out.print(w);
                if ((r.equals(u))) {
                    System.out.print("\"" + (" ") + "\"");
                    //}else
                    //System.out.print("\"" + (o + " " + u) + "\"");
                }
            }
        }
    }
}





