//34527
public class Lab_1 {
    public static void main (String[] args) {

        // одномерный массив а типа long заполнить от 16 до 4
        long [] a = new long [13];
        for (int i = 16; i >= 4; i--) {
            a[16-i]= i;
            // System.out.println(a[16-i]);  //проверка
        }

        // одномерный массив х типа float 17 значений рандомом от -9,0 до 14,0
        float [] x = new float [17];
        for (int i = 0; i < 17; i++) {
            x[i] = ( (float) Math.random() * (14+9) ) - 9;
            // System.out.println(x[i]);  //проверка
        }

        //очень простые формулы из 3 пункта
        double [][] c = new double[13][17];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 17; j++) {
                if (a[i] == 10) {
                    c[i][j] = Math.log(Math.sqrt(Math.abs(x[j])));
                }


                else if (a[i] == 7 || a[i] == 8 || a[i] == 9 || a[i] == 11 || a[i] == 13 || a[i] == 16) {
                    c[i][j] = Math.log( Math.pow ((4 * (Math.pow(((2 * Math.PI)/(2 + Math.abs(x[j]))), x[j]) +1)), (Math.pow((1.0/4.0 + Math.cos(x[j])), 2))));
                }

                else {
                    c[i][j] = Math.cos(Math.pow((Math.atan(1/(Math.pow (Math.E, Math.abs(x[j])))) * (Math.PI + Math.atan (Math.sin(x[j])))), (Math.cbrt(x[j]) - 3)));
                }
            }
        }

        // вывод
        for (int i = 0; i < 13; i++) {
            System.out.println();
            for (int j = 0; j < 17; j++) {
                System.out.printf("%10.5f ", c[i][j]);
            }
        }

    }
}
