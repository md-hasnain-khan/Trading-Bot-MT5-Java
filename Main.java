           /* ....................... This is only Demo Code.................. */


 /*
import io.mtapi.mt5.MT5Client;
import io.mtapi.mt5.MessageHandler;
import io.mtapi.mt5.exception.DecoderException;
import io.mtapi.mt5.network.MetaTraderMessage;
import io.mtapi.mt5.network.enums.*;
import io.mtapi.mt5.network.messages.req.NewOrderReq;
import io.mtapi.mt5.network.messages.res.TradeEvent;
import java.io.IOException;
public class Main {

 // Replace these with your credentials

 private static final String HOST = "15.188.127.36";
 private static final int PORT = 443;
 private static final int USERNAME = 111139222;
 private static final String PASSWORD = "3a40jP7!";

 public static void main(String[] args) {

  // First, create the client instance
  MT5Client mt5Client = new MT5Client(HOST, PORT, new MessageHandler() {
   @Override
   public void onMessage(MetaTraderMessage message, MT5Client client) {
    System.out.println("OnMsgs   "+ System.nanoTime() + " - " + message.toString());
   }

   @Override
   public void onReceiveFailure(DecoderException e) {
    e.printStackTrace();
   }

   @Override
   public void onSendFailure(Exception e) {
    e.printStackTrace();
   }

   @Override
   public void onDisconnected(IOException exception, MT5Client client) {
    exception.printStackTrace();
    System.out.println("DISCONNECTED");
   }

   @Override
   public void onConnected(MT5Client client) {
    System.out.println("Connected");
    System.out.println(client.getConnectedServer());
   }
  });

  try {
   System.out.println("Connecting to MT5...");
   mt5Client.connect(USERNAME, PASSWORD, true, true);

   Thread.sleep(2000);

   // Open the trade
   NewOrderReq newOrderReq = new NewOrderReq();
   newOrderReq.userId = USERNAME;
   newOrderReq.requestId = 123456;
   newOrderReq.placedType = PlacedType.Manually;
   newOrderReq.symbol = "XAUUSD";
   newOrderReq.fillPolicy = FillPolicy.ImmediateOrCancel;
   //newOrderReq.digits = 2;
   newOrderReq.orderType = OrderType.Buy;
   newOrderReq.volume = 100000000;
   newOrderReq.tradeType = TradeType.MarketExecution;
   // newOrderReq.deviation = 1000;
  // newOrderReq.expirationType = ExpirationDateType.GTC;
   //newOrderReq.comment = "NEW MT5 SDK";

   // Measure ONLY the order execution
   long startOpenTime = System.nanoTime();
   TradeEvent tradeEvent = (TradeEvent) mt5Client.sendRequest(newOrderReq);
   System.out.println("Trade Result: " + tradeEvent);
   long endOpenTime = System.nanoTime();

   double openDurationMs = (endOpenTime - startOpenTime) / 1_000_000.0;
   System.out.println("PURE ORDER EXECUTION: " +
           String.format("%.3f", openDurationMs) + " ms");


   Thread.sleep(1000);
   // Measure ONLY the order execution
    startOpenTime = System.nanoTime();
    TradeEvent  tradeEvent2 = (TradeEvent) mt5Client.sendRequest(newOrderReq);
   System.out.println("Trade Result: " + tradeEvent2);
    endOpenTime = System.nanoTime();

    openDurationMs = (endOpenTime - startOpenTime) / 1_000_000.0;
   System.out.println("PURE ORDER EXECUTION: " +
           String.format("%.3f", openDurationMs) + " ms");

   Thread.sleep(5000);

   // Close the trade
   NewOrderReq closeOrderReq = new NewOrderReq();
   closeOrderReq.userId = USERNAME;
   closeOrderReq.requestId = 123457;
   closeOrderReq.placedType = PlacedType.Manually;
   closeOrderReq.symbol = "XAUUSD";
   closeOrderReq.fillPolicy = FillPolicy.ImmediateOrCancel;
   closeOrderReq.digits = 2;
   closeOrderReq.orderType = OrderType.Sell;
   closeOrderReq.volume = 100;
   closeOrderReq.tradeType = TradeType.MarketExecution;
   closeOrderReq.deviation = 1000;
   closeOrderReq.expirationType = ExpirationDateType.GTC;
   closeOrderReq.dealTicket = tradeEvent.tradeResult.ticketNumber;
   closeOrderReq.comment = "CLOSING TRADE";

   mt5Client.sendRequestAsync(closeOrderReq);

   Thread.sleep(5000);

   // Disconnect
   mt5Client.disconnect();
   System.out.println("Disconnected successfully");

  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
*/

                                                      /* ..........this is my real code ..........*/

import io.mtapi.mt5.MT5Client;
import io.mtapi.mt5.MessageHandler;
import io.mtapi.mt5.exception.DecoderException;
import io.mtapi.mt5.network.MetaTraderMessage;
import io.mtapi.mt5.network.enums.*;
import io.mtapi.mt5.network.messages.req.NewOrderReq;
import io.mtapi.mt5.network.messages.res.TradeEvent;


import java.io.IOException;

public class Main {

 private static final String HOST = "15.188.127.36";
 private static final int PORT = 443;
 private static final int USERNAME = 111139222;
 private static final String PASSWORD = "3a40jP7!";
 private static final String SYMBOL = "XAUUSD"; // single point of reference

 public static void main(String[] args) {

  MT5Client mt5Client = new MT5Client(HOST, PORT, new MessageHandler() {
   @Override
   public void onMessage(MetaTraderMessage message, MT5Client client) {

    System.out.println("OnMsgs   " + System.nanoTime() + " - " + message.toString());
   }

   @Override
   public void onReceiveFailure(DecoderException e) {
    e.printStackTrace();
   }

   @Override
   public void onSendFailure(Exception e) {
    e.printStackTrace();
   }

   @Override
   public void onDisconnected(IOException exception, MT5Client client) {
    exception.printStackTrace();
    System.out.println("DISCONNECTED");
   }

   @Override
   public void onConnected(MT5Client client) {
    System.out.println("Connected");
    System.out.println(client.getConnectedServer());
   }
  });

  try {
   System.out.println("Connecting to MT5...");
   mt5Client.connect(USERNAME, PASSWORD, true, true);

   Thread.sleep(2000);
                                        /*................... Open the trade.............*/

   NewOrderReq newOrderReq = new NewOrderReq();
   newOrderReq.userId = USERNAME;
   newOrderReq.requestId = 123456;
   newOrderReq.placedType = PlacedType.Manually;
   newOrderReq.symbol = SYMBOL;
   newOrderReq.fillPolicy = FillPolicy.ImmediateOrCancel;
   newOrderReq.orderType = OrderType.Buy;
   newOrderReq.volume = 100000000;
   newOrderReq.tradeType = TradeType.MarketExecution;

   System.out.println("Placing BUY order for " + SYMBOL);

   long startOpenTime = System.nanoTime();
   TradeEvent tradeEvent = (TradeEvent) mt5Client.sendRequest(newOrderReq);
   System.out.println("Trade Result: " + tradeEvent);
   long endOpenTime = System.nanoTime();

   double openDurationMs = (endOpenTime - startOpenTime) / 1_000_000.0;
   System.out.println("PURE ORDER EXECUTION: " +
           String.format("%.3f", openDurationMs) + " ms");

   Thread.sleep(1000);

   startOpenTime = System.nanoTime();
   TradeEvent tradeEvent2 = (TradeEvent) mt5Client.sendRequest(newOrderReq);
   System.out.println("Trade Result: " + tradeEvent2);
   endOpenTime = System.nanoTime();

   openDurationMs = (endOpenTime - startOpenTime) / 1_000_000.0;
   System.out.println("PURE ORDER EXECUTION: " +
           String.format("%.3f", openDurationMs) + " ms");

   Thread.sleep(5000);

                                             /*................... Close the trade.............*/
   NewOrderReq closeOrderReq = new NewOrderReq();
   closeOrderReq.userId = USERNAME;
   closeOrderReq.requestId = 123457;
   closeOrderReq.placedType = PlacedType.Manually;
   closeOrderReq.symbol = SYMBOL;
   closeOrderReq.fillPolicy = FillPolicy.ImmediateOrCancel;
   closeOrderReq.digits = 2;
   closeOrderReq.orderType = OrderType.Sell;
   closeOrderReq.volume = 100;
   closeOrderReq.tradeType = TradeType.MarketExecution;
   closeOrderReq.deviation = 1000;
   closeOrderReq.expirationType = ExpirationDateType.GTC;
   closeOrderReq.dealTicket = tradeEvent.tradeResult.ticketNumber;
   closeOrderReq.comment = "CLOSING TRADE";

   System.out.println("Closing trade...");
   mt5Client.sendRequestAsync(closeOrderReq);

   Thread.sleep(5000);

   mt5Client.disconnect();
   System.out.println("Disconnected successfully");

  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
