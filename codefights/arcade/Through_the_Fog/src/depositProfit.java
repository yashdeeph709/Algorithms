int depositProfit(int deposit, int rate, int threshold) {
    double depositd=deposit;
    double rated=rate;
    double thresholdd=threshold;
    double base=(1+rated/100);
    double main=thresholdd/depositd;
    System.out.println("base:"+base+" main"+main);
    return (int)Math.ceil(logb(main,base));
}
public static double logb( double a, double b )
{
return Math.log(a) / Math.log(b);
}