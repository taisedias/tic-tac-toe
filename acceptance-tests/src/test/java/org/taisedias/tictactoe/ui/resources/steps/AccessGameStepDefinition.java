package org.taisedias.tictactoe.ui.resources.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.taisedias.tictactoe.ui.resources.pages.GamePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccessGameStepDefinition {
    private GamePage gamePage = new GamePage();

    @When("^I access tic tac toe game$")
    public void i_access_tic_tac_toe_game()  throws Throwable {
        gamePage.access();
    }

    @Then("^I do not see the game$")
    public void i_see_the_game() throws Throwable {
        assertThat(gamePage.getTitle(), is("Problem loading page"));
    }

}
