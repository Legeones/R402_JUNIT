import TP.BankManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class BankManagerSteps {
    private BankManager bankManager;

    @Given("Un nouveau compte bancaire {} est cree avec un solde initial de {}")
    public void je_suis_sur_la_page_transaction(int num, int solde){
        bankManager = new BankManager();
        bankManager.create(num);
        bankManager.deposit(num, solde);
    }


    @When("Je depose {} dans le compte {}")
    public void jeDeposeDansLeCompte(int arg0, int arg1) {
        bankManager.deposit(arg1, arg0);
    }

    @Then("Le solde du compte {} est de {}")
    public void leSoldeDuCompteEstDe(int arg0, int arg1) {
        assertEquals(arg1, bankManager.getBalance(arg0));
    }

    @And("Je retire le {} dans le compte {}")
    public void jeRetireLeDansLeCompte(int arg0, int arg1) {
        bankManager.withdraw(arg1, arg0);
    }

    @Given("Plusieurs comptes bancaires avec un solde de {}")
    public void plusieursComptesBancairesAvecUnSoldeDe(int arg0) {
        bankManager = new BankManager();
        for (int i = 1; i<=10; i++){
            bankManager.create(i);
            bankManager.deposit(i, arg0);
        }
    }

    @When("Je transfert {} dans le compte {} depuis le compte {}")
    public void jeTransfertDansLeCompteDepuisLeCompte(int arg0, int arg1, int arg2) {
        bankManager.withdraw(arg2, arg0);
        bankManager.deposit(arg1, arg0);
    }

}
