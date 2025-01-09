# Game-examination
Dragon treasure project game for java

Antaganden:
Spelaren kan avsluta spelet utan att hitta utgången.
Spelaren vinner spelet genom att öppna skattkistan, och ta skatten ut ur dungeon. Man vinner genom att hitta utgången med guldet i sin inventory, utgången genom skattrummet.

Alla rum är kopplade till varandra med hjälp av dörrar, som kan vara låsta eller olåsta.
Dörrar kan låsas upp med en nyckel, som är ett föremål spelaren kan plocka upp.
Om en dörr är låst och spelaren inte har nyckeln, visas ett meddelande, och spelaren hindras från att gå genom dörren.
När man går in i grottan kan man inte gå tillbaka eftersom utgången har kollapsat!

Spelet börjar utanför grottan.
Skattkistan finns i ett specifikt rum som är låst och nyckeln till rummet placeras slumpmässigt i ett av de inre rummen vid spelets start.
Spelaren har en inventarie (ArrayList<Item>) som lagrar de föremål spelaren plockar upp.
Spelaren kan endast plocka upp 1 item åt gången, så om ett rum har 2 items som spelaren vill plocka upp då får man plocka upp 1 först och sedan gå ut och in i rummet igen för att plocka upp det andra item. 


Goblin i ett rum placerat och draken i det låsta rummet med kistan.

1 nyckel endast, till det låsta rummet med skattkistan, dvs inte för skattkistan. Skattkistan är redan öppen när man går in i rummet

Man vinner genom att hitta utgången med guldet i sin inventory, utgången är genom skattrummet.

Healing potion som ger 10 HP, så om du har 10 så blir det 20. Du kan ta healing potion i combat, inte annars.
Drake, 15HP 2 i attack.
Goblin 5 Hp, 1 i attack.

Spelaren 10 HP, 1 i attack men med Scalibur 3 i attack.
Scalibur är ett svärd spelaren kan hitta. 

