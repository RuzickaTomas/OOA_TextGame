/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import eu.pedu.adv16s_fw.scenario.AScenarioManager;
import eu.pedu.adv16s_fw.scenario.ScenarioStep;
import eu.pedu.adv16s_fw.scenario.TypeOfScenario;

import static eu.pedu.adv16s_fw.scenario.TypeOfStep.*;

/**
 * *****************************************************************************
 * Instance of the {@code RUPScenarioManagerLit} class serves as scenario
 * manager, that has to manage the scenarios of the associated game. These
 * scenarios should allow to test and demonstrate the functionality of the
 * associated game.
 * <p>
 * Each manager has to offer:
 * <ul>
 * <li>The <b>happy scenario</b> (the basic successful one) demonstrating
 * certain successful path through the game possibilities leading to the game
 * goal.
 * </li>
 * <li>The <b>mistake scenario</b>
 * demonstrating the game reaction to the wrongly entered commands.
 * </li>
 * </ul>
 * <p>
 * Individual managed scenarios have to differ by their names; the names of the
 * happy scenario and the mistake one are firmly pre-determined and cannot be
 * arbitrarily set.
 * <p>
 * Individual scenarios are iterable and "streamable" sequences of steps
 * specified by instances of the framework class
 * {@link eu.pedu.adv16s_fw.scenario.ScenarioStep}, to which the designed game
 * should associated.
 * <p>
 * Scenario manager is a singleton, that is responsible for all scenarios
 * concerning the game associated with it.
 *
 * @author Tomáš RŮŽIČKA
 * @version 2016-Summer
 */
public class HraScenarioManager extends AScenarioManager
        implements IAuthorHry {
//== CONSTANT CLASS FIELDS =====================================================

    /**
     * *************************************************************************
     * The initial game step identical for all scenarios.
     * <p>
     * Constructor of the full-fledged {@link ScenarioStep} class instance
     * requires the following parameters:
     * <pre> {@code
     * TypeOfStep typeOfStep; //Type of the given scenario step
     * String     command;    //Command realizing this scenario step
     * String     message;    //Message written after entering the command
     * String     space;      //Current space after entering the command
     * String[]   neighbors;  //Neighbors of the current space (= exits)
     * String[]   items;      //Items occuring in the current space
     * String[]   bag;        //Current bag content
     * }</pre>
     * =======================================================================
     * <br>
     * Scenario steps have to comply with the following requirements:
     * <ul>
     * <li>None the items may contain the {@code null} value.</li>
     * <li>With the exception of {@code command} no string may be empty (i.e.
     * {@code ""})</li>
     * <li>Empty string may occur neither as an item in the array
     * {@code neighbors}, nor {@code items} nor {@code bag}</li>
     * </ul>
     * <br>
     * ************************************************************************
     */
    public static final ScenarioStep START_STEP
            = new ScenarioStep(0, tsSTART, "",
                    "\n Vítejte ve hře SpyGame,"
                    + "\n Vaším úkolem je proplížit se kolem"
                    + "\n Stráží a zabít nepřítele. Hodně štěstí ",
                    "Vstupní_hala",
                    new String[]{"Strážnice", "Chodba"},
                    new String[]{"Víno", "Převlek"},
                    new String[]{}
            );

    /**
     * *************************************************************************
     * Steps of the happy scenario describing the expectable successful game
     * running. It is not necessary for the scenario compiled of these steps to
     * be the shortest possible (it implies, that it has not to be the true
     * basic successful scenario), but it has to comply with all marginal
     * conditions of the assignment, i.e. it has to contain minimal number of
     * steps, pass through the required minimal number of spaces and demonstrate
     * using of all required actions.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS
            = {
                START_STEP,
                new ScenarioStep(tsHELP, "pomoc",
                        "Nápověda \n" + "#####################################",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno", "Převlek"},
                        new String[]{}
                ),
                new ScenarioStep(tsTAKE, "Vem Víno",
                        "Chcete vzít Víno",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Převlek"},
                        new String[]{"Víno"}
                ),
                new ScenarioStep(tsTAKE, "Vem Převlek",
                        "Chcete vzít Převlek",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{},
                        new String[]{"Víno", "Převlek"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Chodba",
                        "Jdete do Chodba",
                        "Chodba",
                        new String[]{"Strážnice", "Vstupní_hala",
                                     "Cílová_oblast"
                        },
                        new String[]{"Lampa"},
                        new String[]{"Víno", "Převlek"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Strážnice",
                        "Jdete do Strážnice",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Víno", "Převlek"}
                ),
                
                new ScenarioStep(tsPUT_DOWN, "Dej Víno",
                        "Vyndal jste Víno",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Víno", "Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Komunikační_místnost",
                        "Jdete do Komunikační_místnost",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč", "Kódy"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsTAKE, "Vem Klíč",
                        "Chcete vzít Klíč",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Kódy"},
                        new String[]{"Převlek", "Klíč"}
                ),
                new ScenarioStep(tsTAKE, "Vem Kódy",
                        "Chcete vzít Kódy",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Klíč", "Kódy"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Zbrojnice",
                        "Jdete do Zbrojnice",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", "Panzerfaust"
                                    ,"Dveře"},
                        new String[]{"Převlek", "Klíč", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD2, "Použij Klíč Dveře",
                        "Otevřít Dveře pomocí Klíč",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Klíč", "Pistole", "Kulomet", "Panzerfaust"
                                    ,"Dveře"},
                        new String[]{"Převlek", "Kódy"}
                ),
                //                new ScenarioStep(tsDIALOG, "Heslo",
                //                        "Jdi dál",
                //                        "Zbrojnice",
                //                        new String[]{"Velký_sál","Strážnice",
                //                                     "Komunikační_místnost"},
                //                      new String[]{"Klíč","Pistole", "Kulomet"
                //                                  ,"Panzerfaust","Dveře"},
                //                        new String[]{"Převlek", "Kódy"}
                //                ),
                //                
                new ScenarioStep(tsTAKE, "Vem Pistole",
                        "Chcete vzít Pistole",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Klíč", "Kulomet", "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy", "Pistole"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Komunikační_místnost",
                        "Jdete do Komunikační_místnost",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Velký_sál",
                        "Jdete do Velký_sál",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD1, "Zhasni Vypínač",
                        "Vypnul jste Vypínač",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Cílová_oblast",
                        "Jdete do Cílová_oblast",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD2, "Zabij Nepřítel Pistole",
                        "Zabil jste nepřítel pomocí pistole",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD2, "Využij Kódy Trezor",
                        "Otevřít dveře trezor pomocí kódy",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty", "Kódy"},
                        new String[]{"Převlek", "Pistole"}
                ),
                new ScenarioStep(tsTAKE, "Vem Dokumenty",
                        "Chcete vzít Dokumenty",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Kódy"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Chodba",
                        "Jdete do Chodba",
                        "Chodba",
                        new String[]{"Strážnice", "Vstupní_hala",
                                     "Cílová_oblast"
                        },
                        new String[]{"Lampa"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Vstupní_hala",
                        "Jdete do Vstupní_hala",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                new ScenarioStep(tsEND, "End",
                        "Game Over, have a nice day",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),};

    /**
     * Step testing the incorrect game starting is defined separately, so that
     * the indexes of the following steps could be simply adjusted.
     */
    private static final ScenarioStep WRONG_START
            = new ScenarioStep(-1,
                    tsNOT_START, "Start",
                    "\nThe first command is not the starting one.\n"
                    + "Game that does not run can be started "
                    + "only with a starting command.\n",
                    "",
                    new String[]{},
                    new String[]{},
                    new String[]{}
            );

    static {
        ScenarioStep.setIndex(1);
    }

    /**
     * *************************************************************************
     * Mistake scenario defining reactions to mandatory set of types of
     * incorrectly given commands.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS
            = {
                WRONG_START,
                START_STEP,
  //------------------------------------------------            
  //************************************************
  //----------------------- Vstupní_hala -----------
  //************************************************
                
                new ScenarioStep(tsEMPTY, "",
                        "Zadal jsi prázdný příkaz",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno", "Převlek"},
                        new String[]{}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno", "Převlek"},
                        new String[]{}
                ),
                new ScenarioStep(tsHELP, "pomoc",
                        "Nápověda \n" + "#####################################",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno", "Převlek"},
                        new String[]{}
                ),
                new ScenarioStep(tsTAKE_WA, "Vem",
                        "Co vlastně chcete vzít",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno", "Převlek"},
                        new String[]{}
                ),
                new ScenarioStep(tsTAKE, "Vem Převlek",
                        "Chcete vzít Převlek",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek"}),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsBAD_NEIGHBOR, "Jdi Komunikační_místnost",
                        "Tam se nyní nelze dostat",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsBAD_NEIGHBOR, "Jdi Velký_sál",
                        "Tam se nyní nelze dostat",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek"}
                ),
                
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //---------------------------- Chodba ------------
                //************************************************          
                new ScenarioStep(tsMOVE, "Jdi Chodba",
                        "Jdete do Chodba",
                        "Chodba",
                        new String[]{"Strážnice", "Vstupní_hala", 
                                     "Cílová_oblast"
                        },
                        new String[]{"Lampa"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Chodba",
                        new String[]{"Strážnice", "Vstupní_hala",
                                     "Cílová_oblast"
                        },
                        new String[]{"Lampa"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Chodba",
                        new String[]{"Strážnice", "Vstupní_hala",
                                     "Cílová_oblast"
                        },
                        new String[]{"Lampa"},
                        new String[]{"Převlek"}
                ),
                
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //---------------------------- Strážnice ---------
                //************************************************            

                new ScenarioStep(tsMOVE, "Jdi Strážnice",
                        "Jdete do Strážnice",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsPUT_DOWN_WA, "Dej",
                        "Co chcete vyndat",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsBAD_ITEM, "Vem Klíč",
                        "Klíč se tady nenachází",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsBAD_ITEM, "Vem Kódy",
                        "Kódy se tady nenachází",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsNOT_IN_BAG, "Dej Víno",
                        "Nemáte Víno",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Převlek"}
                ),
                
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //------------ Komunikační_místnost --------------
                //************************************************

                new ScenarioStep(tsMOVE, "Jdi Komunikační_místnost",
                        "Jdete do Komunikační_místnost",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč", "Kódy"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč", "Kódy"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsTAKE_WA, "Vem",
                        "Co vlastně chcete vzít",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč", "Kódy"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsBAD_ITEM, "Vem Víno",
                        "Víno se tady nenachází",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč", "Kódy"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsBAD_ITEM, "Vem Pistole",
                        "Pistole se tady nenachází",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč", "Kódy"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsTAKE, "Vem Kódy",
                        "Chcete vzít Kódy",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsPUT_DOWN_WA, "Dej",
                        "Co chcete vyndat",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsNOT_IN_BAG, "Dej Klíč",
                        "Nemáte Klíč",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsTAKE_WA, "Vem",
                        "Co vlastně chcete vzít",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{"Klíč"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsTAKE, "Vem Klíč",
                        "Chcete vzít Klíč",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Klíč", "Kódy"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Klíč", "Kódy"}
                ),
                
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //-------------------- Zbrojnice -----------------
                //************************************************
                
                new ScenarioStep(tsMOVE, "Jdi Zbrojnice",
                        "Jdete do Zbrojnice",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", 
                                     "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Klíč", "Kódy"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", 
                                     "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Klíč", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD2, "Použij Klíč Dveře",
                        "Otevřít Dveře pomocí Klíč",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", "Klíč", 
                                     "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsUNMOVABLE, "Vem Kulomet",
                        "Kulomet neunesete",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", "Klíč", 
                                     "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsUNMOVABLE, "Vem Panzerfaust",
                        "Panzerfaust neunesete",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", "Klíč",
                                     "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsTAKE_WA, "Vem",
                        "Co vlastně chcete vzít",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Pistole", "Kulomet", "Klíč", 
                                     "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy"}
                ),
                new ScenarioStep(tsTAKE, "Vem Pistole",
                        "Chcete vzít Pistole",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Kulomet", "Klíč", "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy", "Pistole"}
                ),
                new ScenarioStep(tsBAG_FULL, "Vem Klíč",
                        "Klíč se do batohu už nevejde",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Kulomet", "Klíč", "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy", "Pistole"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Zbrojnice",
                        new String[]{"Velký_sál", "Strážnice",
                            "Komunikační_místnost"},
                        new String[]{"Kulomet", "Klíč", "Panzerfaust", "Dveře"},
                        new String[]{"Převlek", "Kódy", "Pistole"}
                ),
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //---------- Komunikační_místnost - zpět ---------
                //************************************************

                new ScenarioStep(tsMOVE, "Jdi Komunikační_místnost",
                        "Jdete do Komunikační_místnost",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsBAD_NEIGHBOR, "Jdi Vstupní_hala",
                        "Tam se nyní nelze dostat",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsBAD_NEIGHBOR, "Jdi Chodba",
                        "Tam se nyní nelze dostat",
                        "Komunikační_místnost",
                        new String[]{"Velký_sál", "Zbrojnice", "Strážnice"},
                        new String[]{},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
               
                //++++++++++++++++++++++++++++++++++++++++++++++++            
                //************************************************
                //---------------- Velký_sál ---------------------
                //************************************************             

                new ScenarioStep(tsMOVE, "Jdi Velký_sál",
                        "Jdete do Velký_sál",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsUNMOVABLE, "Vem Alarm",
                        "Alarm neunesete",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsUNMOVABLE, "Vem Vypínač",
                        "Vypínač neunesete",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD1, "Zhasni Vypínač",
                        "Vypnul jste Vypínač",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsBAD_NEIGHBOR, "Jdi Vstupní_hala",
                        "Tam se nyní nelze dostat",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsBAD_NEIGHBOR, "Jdi Chodba",
                        "Tam se nyní nelze dostat",
                        "Velký_sál",
                        new String[]{"Komunikační_místnost",
                            "Cílová_oblast", "Zbrojnice"},
                        new String[]{"Vypínač", "Alarm"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
               
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //---------------- Cílová_oblast -----------------
                //************************************************

                new ScenarioStep(tsMOVE, "Jdi Cílová_oblast",
                        "Jdete do Cílová_oblast",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsUNKNOWN, "xxx",
                        "Toto mi není známo",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                
                new ScenarioStep(tsNON_STANDARD2, "Zabij Nepřítel Pistole",
                        "Zabil jste Nepřítel pomocí Pistole",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty"},
                        new String[]{"Převlek", "Pistole", "Kódy"}
                ),
                new ScenarioStep(tsNON_STANDARD2, "Využij Kódy Trezor",
                        "Otevřít dveře Trezor pomocí Kódy",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty", "Kódy"},
                        new String[]{"Převlek", "Pistole"}
                ),
                new ScenarioStep(tsTAKE_WA, "Vem",
                        "Co vlastně chcete vzít",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty", "Kódy"},
                        new String[]{"Převlek", "Pistole"}
                ),
                new ScenarioStep(tsUNMOVABLE, "Vem Trezor",
                        "Trezor neunesete",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Dokumenty", "Kódy"},
                        new String[]{"Převlek", "Pistole"}
                ),
                new ScenarioStep(tsTAKE, "Vem Dokumenty",
                        "Chcete vzít Dokumenty",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Kódy"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Cílová_oblast",
                        new String[]{"Chodba", "Strážnice", "Velký_sál"},
                        new String[]{"Nepřítel", "Trezor", "Kódy"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //-------------- Chodba - zpět -------------------
                //************************************************             

                new ScenarioStep(tsMOVE, "Jdi Chodba",
                        "Jdete do Chodba",
                        "Chodba",
                       new String[]{"Strážnice", "Vstupní_hala", "Cílová_oblast"
                        },
                        new String[]{"Lampa"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                new ScenarioStep(tsMOVE_WA, "Jdi",
                        "Napište kam chcete jít",
                        "Chodba",
                       new String[]{"Strážnice", "Vstupní_hala", "Cílová_oblast"
                        },
                       new String[]{"Lampa"},
                       new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
               
                //++++++++++++++++++++++++++++++++++++++++++++++++
                //************************************************
                //------------- Vstupní_hala - zpět --------------
                //************************************************             

                new ScenarioStep(tsMOVE, "Jdi Vstupní_hala",
                        "Jdete do Vstupní_hala",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),
                new ScenarioStep(tsEND, "End",
                        "Game Over, have a nice day",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno"},
                        new String[]{"Převlek", "Pistole", "Dokumenty"}
                ),};

    static {
        ScenarioStep.setIndex(1);
    }
    ;
    
  
//------------------------------------------------
//------------------Required_Steps----------------
//++++++++++++++++++++++++++++++++++++++++++++++++
    
        private static final ScenarioStep[] REQUIRED_STEPS
            = {
                START_STEP,
                new ScenarioStep(tsHELP, "pomoc",
                        "Nápověda \n" + "#####################################",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Víno", "Převlek"},
                        new String[]{}),
                new ScenarioStep(tsTAKE, "Vem Víno",
                        "Chcete vzít Víno",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{"Převlek"},
                        new String[]{"Víno"}
                ),
                new ScenarioStep(tsTAKE, "Vem Převlek",
                        "Chcete vzít Převlek",
                        "Vstupní_hala",
                        new String[]{"Strážnice", "Chodba"},
                        new String[]{},
                        new String[]{"Víno", "Převlek"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Chodba",
                        "Jdete do Chodba",
                        "Chodba",
                       new String[]{"Strážnice", "Vstupní_hala", "Cílová_oblast"
                        },
                       new String[]{"Lampa"},
                       new String[]{"Víno", "Převlek"}
                ),
                new ScenarioStep(tsMOVE, "Jdi Strážnice",
                        "Jdete do Strážnice",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Stráž"},
                        new String[]{"Víno", "Převlek"}
                ),
                new ScenarioStep(tsPUT_DOWN, "Dej Víno",
                        "Vyndal jste Víno",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Víno", "Stráž"},
                        new String[]{"Převlek"}
                ),
                new ScenarioStep(tsEND, "End",
                        "Game Over, have a nice day",
                        "Strážnice",
                        new String[]{"Vstupní_hala", "Chodba", "Cílová_oblast",
                            "Velký_sál", "Zbrojnice", "Komunikační_místnost"},
                        new String[]{"Víno", "Stráž"},
                        new String[]{"Převlek"}
                ),};
    private static final String REQUIRED_STEPS_SCENARIO_NAME = "_REQUIRED_";

    /**
     * The only instance of this class. It manages all scenarios of the
     * associated game.
     */
    private static final HraScenarioManager MANAGER
            = new HraScenarioManager();

//== VARIABLE CLASS FIELDS =====================================================
//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
    /**
     * *************************************************************************
     * Static constructor is placed before definitions of constants
     * {@link #AGE}, {@link #THIS_YEAR} and {@link #BORN_YEAR} and once again
     * before the definition of a constant {@link MISTAKE_SCENARIO_STEPS}. Such
     * initialization should be before each further constant defining the steps
     * of the following scenario.
     */
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================
//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================
    /**
     * *************************************************************************
     * Returns scenario manager - the only instance of this class.
     *
     * @return Scenario manager
     */
    public static HraScenarioManager getInstance() {
        return MANAGER;
    }

    /**
     * *************************************************************************
     * Creates an instance representing the game scenario manager. Within the
     * constructor framework it is suitable to create all scenarios and seal the
     * scenario manager after it.
     * <p>
     * Individual managed scenarios have to differ by their names, the names of
     * the happy scenario and the mistake one are firmly pre-determined and
     * cannot be changed. Names given to them in the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method are
     * therefore only formal, because the called method assignes to them the
     * names defined in advance in appropriate constants.
     * <p>
     * ´Contract of the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * requires so that the happy scenario, i.e. scenario of the
     * {@link TypeOfScenario.scHAPPY}) type, would be added as the first one,
     * and the mistake scenario, i.e. the scenario of the
     * {@link MISTAKE_SCENARIO_NAME} type, as the second one. The order of the
     * subsequently added scenarios is not decisive.
     */
    private HraScenarioManager() {
        super(FACTORY_CLASS);

        addScenario(HAPPY_SCENARIO_NAME,
                TypeOfScenario.scHAPPY, HAPPY_SCENARIO_STEPS);
        addScenario(MISTAKE_SCENARIO_NAME,
                TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        //přidaný scénář
        addScenario(REQUIRED_STEPS_SCENARIO_NAME, TypeOfScenario.scGENERAL,
                REQUIRED_STEPS);
        seal();
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//##############################################################################
//== NESTED DATA TYPES =========================================================
//##############################################################################
//== TEST METHODS AND CLASSES ==================================================
    /**
     * *************************************************************************
     * Method verifying the given scenario manager and the associated game by
     * scenarios of this manager.
     * <p>
     * The scenario manager is verified if it complies with the following
     * conditions:
     * <ul>
     * <li>It knows to return properly formated name of the game author and
     * his/her ID.</li>
     * <li>It defines the happy scenario and the mistake one.</li>
     * <li>The mistake scenario has the following properties:
     * <ul>
     * <li>Starting command, the name of which is an empty string</li>
     * <li>Minimal required number of steps</li>
     * <li>Minimal number of visited spaces</li>
     * <li>Minimal number of "glimpsed" spaces</li>
     * <li>Minimal number of own (optional) actions</li>
     * <li>Usage of actions for moving from the current space to a neighboring
     * space, taking item and putting down item</li>
     * <li>Cross consistence of actions and states after execution of the
     * actions</li>
     * </ul>
     * </li>
     * <li>The mistake scenario has the following properties:
     * <ul>
     * <li>Incorrect starting by a not empty command,</li>
     * <li>Starting command the name of which is an empty string</li>
     * <li>Usage of all mandatory error step types defined in the<br>
     * {@link eu.pedu.adv16s_fw.scenario.TypeOfStep} enum type</li>
     * <li>Asking for a help</li>
     * <li>Premature game termination</li>
     * </ul>
     * </li>
     * </ul>
     * <p>
     * The game is verified if it can be played exactly as is planned in
     * scenarios.
     *
     * @param args Command line parameters - unused.
     */
    public static void main(String[] args) {
        //Tests if the scenario manager and its scenarios
        //comply with requirements
//%U+ «A107
          MANAGER.autoTest();

        //Simulates playing the game according to happy scenario
        // MANAGER.getHappyScenario().simulate();
        //Game testing made gradually according to both mandatory scenarios,
        //the happy scenario is passed twice one after the other
       // MANAGER.testGame();
        //Game testing according to scenarios with the given names
        //MANAGER.testGameByScenarios(REQUIRED_STEPS_SCENARIO_NAME);
        //Playing the game according to the scenario with the given name
        //  MANAGER.playGameByScenario("???");
        System.exit(0);
    }

}
