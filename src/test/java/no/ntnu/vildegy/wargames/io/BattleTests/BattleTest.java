package no.ntnu.vildegy.wargames.io.BattleTests;

import no.ntnu.vildegy.wargames.model.Army;
import no.ntnu.vildegy.wargames.model.Battle;
import no.ntnu.vildegy.wargames.model.CavarlyUnit;
import no.ntnu.vildegy.wargames.model.CommanderUnit;
import no.ntnu.vildegy.wargames.model.RangedUnit;
import no.ntnu.vildegy.wargames.model.Unit;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

 public class BattleTest {

         @Test
         @DisplayName("Checking winning army has units left")
         public void winningArmyHasUnitsLeft() {
             RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
             CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
             CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

             ArrayList<Unit> units = new ArrayList<Unit>();
             units.add(rangedUnit);
             units.add(cavarlyUnit);
             units.add(commanderUnit);

             Army army1 = new Army("army1", units);


             ArrayList<Unit> units2 = new ArrayList<>();
             units2.add(rangedUnit);
             Army army2 = new Army("army2", units2);


             Battle battle = new Battle(army1, army2);
             Army winningArmy = battle.simulate();

             assertTrue(winningArmy.hasUnits());
             if (!winningArmy.equals(army2))
                 assertFalse(army2.hasUnits());
             else
                 assertFalse(army1.hasUnits());
         }
     }
