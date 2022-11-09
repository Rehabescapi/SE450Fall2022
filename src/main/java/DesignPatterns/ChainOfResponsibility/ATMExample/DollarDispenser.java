package DesignPatterns.ChainOfResponsibility.ATMExample;

public class DollarDispenser implements DispenseChain {

    private DispenseChain chain;
    private int Currency;

    DollarDispenser(int c){
        this.Currency = c;
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= Currency){
            int num = cur.getAmount()/Currency;
            int remainder = cur.getAmount() % Currency;
            System.out.println("Dispensing "+num+" "+Currency+"$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }

}
