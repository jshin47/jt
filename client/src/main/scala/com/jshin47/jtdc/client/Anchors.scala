package com.jshin47.jtdc.client

sealed trait Loc

case object LandingLoc extends Loc
case object DemonstrationLoc extends Loc

sealed trait Error_Loc extends Loc
case object Error_404_Loc extends Loc