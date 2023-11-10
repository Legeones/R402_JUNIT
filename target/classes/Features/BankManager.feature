Feature: Manager
  En tant que manager
  Je veux gerer les comptes
  A fin de connaitre la situation du bank

  @Depot
    Scenario Outline: Depot
      Given Un nouveau compte bancaire <num> est cree avec un solde initial de <solde>
      When Je depose <montant> dans le compte <num>
      Then Le solde du compte <num> est de <resultat>
    Examples:
      | num | solde | montant | resultat |
      | 1   | 1000  | 500     | 1500     |

  @DepotPuisRetrait
    Scenario Outline: Depot puis retrait
      Given Un nouveau compte bancaire <num> est cree avec un solde initial de <solde>
      When Je depose <montant> dans le compte <num>
      And Je retire le <montant2> dans le compte <num>
      Then Le solde du compte <num> est de <resultat>
      Examples:
        | num | solde | montant | montant2 | resultat |
        | 1   | 1000  | 500     | 100      | 1400     |

  @EnvoiUnCompteAUnAutre
    Scenario Outline: Envoi
      Given Plusieurs comptes bancaires avec un solde de <solde>
      When Je transfert <montant> dans le compte <num> depuis le compte <num2>
      Then Le solde du compte <num2> est de <resultat2>
      Then Le solde du compte <num> est de <resultat>
      Examples:
        | solde | montant | num | num2 | resultat | resultat2 |
        | 1000  | 500     | 1   | 3    | 1500     | 500       |

  @RetraitSousDécouvert
  Scenario Outline: Decouvert
    Given Un nouveau compte bancaire <num> est cree avec un solde initial de <solde>
    When Le compte <num> a un decouvert de <decouvert>
    Then Obtient une exception de decouvert avec le retrait le <montant> dans le compte <num>
    Examples:
      | num | solde | decouvert | montant |
      | 1   | 1000  | -500      | 1600    |

