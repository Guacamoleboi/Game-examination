# Game-examination
Dragon treasure project game for java

Antaganden:
Spelaren kan avsluta spelet utan att hitta utgången.
Spelaren vinner spelet genom att öppna skattkistan, och ta skatten ut ur dungeon. 

Alla rum är kopplade till varandra med hjälp av dörrar, som kan vara låsta eller olåsta.
Dörrar kan låsas upp med en nyckel, som är ett föremål spelaren kan plocka upp.
Om en dörr är låst och spelaren inte har nyckeln, visas ett meddelande, och spelaren hindras från att gå genom dörren.

Spelet börjar utanför grottan.
Skattkistan finns i ett specifikt rum som är låst och nyckeln till rummet placeras slumpmässigt i ett av de inre rummen vid spelets start.
Spelaren har en inventarie (ArrayList<Item>) som lagrar de föremål spelaren plockar upp.

Obs: Item delen är inte färdig utvecklat än, och antagande om spelaren ska hitta 1 eller 2 nycklar har inte gjorts än.

Exit efter att hittat skatten - utgången genom skattrummet

Random placera monster, men kanske inte draken (skattrum eller utanför skattrum)??
1 nyckel endast, till det låsta rummet med skattkistan, dvs inte för skattkistan. Skattkistan är redan öppen när man går in i rummet
Grattis meddelande om man hittar utgången och har skatten. If else, exit meddelande. 
Healing potion, drake, minst 1 monster, 
Spelaren börjar redan med ett svärd, för ingen vettig hade gått in i en dungeon utan vapen. 
--Sköld?
-- super strenght potion 
-- Börjar utan svärd?
Gold är en item? chest en container
