package manyongCrush;

import javax.swing.ImageIcon;

public class Fireball extends SkillImpact {

   public Fireball(Player player, int x, int y, int power, int skillPower, int skillWidth, int skillHeight) {
      super(player, x, y, power, skillPower, skillWidth, skillHeight);

      initData();

      skillsFly();

   }

   public void initData() {

      super.setSkillImageL(new ImageIcon("images/fireBallL.png"));
      super.setSkillImageR(new ImageIcon("images/fireBallR.png"));

   }
}