package Steps;

import TP.BankAccountManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountManagerSteps {
    private BankAccountManager bankAccountManager;

    @Given("Un nouveau compte bancaire {} est cree avec un solde initial de {}")
    public void je_suis_sur_la_page_transaction2(int num, int solde){
        bankAccountManager = new BankAccountManager();
        bankAccountManager.create(num);
        bankAccountManager.deposit(num, solde);
    }


    @When("Je depose {} dans le compte {}")
    public void jeDeposeDansLeCompte2(int arg0, int arg1) {
        bankAccountManager.deposit(arg1, arg0);
    }

    @Then("Le solde du compte {} est de {}")
    public void leSoldeDuCompteEstDe2(int arg0, int arg1) {
        assertEquals(arg1, bankAccountManager.getBalance(arg0));
    }

    @And("Je retire le {} dans le compte {}")
    public void jeRetireLeDansLeCompte2(int arg0, int arg1) {
        bankAccountManager.withdraw(arg1, arg0);
    }

    @Given("Plusieurs comptes bancaires avec un solde de {}")
    public void plusieursComptesBancairesAvecUnSoldeDe2(double arg0) {
        bankAccountManager = new BankAccountManager();
        for (int i = 1; i<=10; i++){
            bankAccountManager.create(i);
            bankAccountManager.deposit(i, arg0);
        }
    }

    @When("Je transfert {} dans le compte {} depuis le compte {}")
    public void jeTransfertDansLeCompteDepuisLeCompte2(double arg0, int arg1, int arg2) {
        bankAccountManager.withdraw(arg2, arg0);
        bankAccountManager.deposit(arg1, arg0);
    }


    @Then("Obtient une exception de decouvert avec le retrait le {} dans le compte {}")
    public void obtientUneExceptionDeDecouvertAvecLeRetraitLeDansLeCompte(double arg0, int arg1) {
        assertThrows(Exception.class, () -> {
            bankAccountManager.withdraw(arg1, arg0);
        });
    }

    @When("Le compte {} a un decouvert de {}")
    public void leCompteAUnDecouvertDe(int arg0, double arg1) {
        bankAccountManager.ajoutDecouvert(arg0, arg1);
    }
}
