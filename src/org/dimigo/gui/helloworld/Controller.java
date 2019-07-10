package org.dimigo.gui.helloworld;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Controller implements Initializable{
    @FXML
    public Button now1, now2, now3, best1, best2, best3;
    @FXML
    public ListView<String> listview1;
    @FXML
    public ListView<String> listview2;
    @FXML
    public ListView<String> listview3;
    @FXML
    public ComboBox<String> CB;

    ObservableList<String> ilbeBest = FXCollections.observableArrayList();
    ObservableList<String> ilbeNow = FXCollections.observableArrayList();
    ObservableList<String> ilbeBestAll = FXCollections.observableArrayList();
    ObservableList<String> ilbeNowAll = FXCollections.observableArrayList();

    ObservableList<String> ouBest = FXCollections.observableArrayList();
    ObservableList<String> ouNow = FXCollections.observableArrayList();
    ObservableList<String> ouBestAll = FXCollections.observableArrayList();
    ObservableList<String> ouNowAll = FXCollections.observableArrayList();

    ObservableList<String> ruriwebBest = FXCollections.observableArrayList();
    ObservableList<String> ruriwebNow = FXCollections.observableArrayList();
    ObservableList<String> ruriwebBestAll = FXCollections.observableArrayList();
    ObservableList<String> ruriwebNowAll = FXCollections.observableArrayList();

    ObservableList<String> CBList = FXCollections.observableArrayList("전체", "정치/시사");


    List<String> K_ilbeBest, K_ilbeNow, K_ouBest, K_ouNow, K_ruliwebBest, K_ruliwebNow, K_ilbeBestAll, K_ilbeNowAll, K_ouBestAll, K_ouNowAll, K_ruliwebBestAll, K_ruliwebNowAll;
    boolean bestButtonOn1=true, bestButtonOn2=true, bestButtonOn3=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Document ilbeBest = Jsoup.connect("http://www.ilbe.com/list/politics?sub=best").get();  //일베 베스트
            Elements E_ilbeBest = ilbeBest.select("[class=\"subject \"]");

            K_ilbeBest = E_ilbeBest.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeBestSite = Jsoup.connect("http://www.ilbe.com/list/politics?sub=best").get();  //일베 베스트 사이트
            Elements E_ilbeBestSite = ilbeBestSite.select("[class=\"board-list\"]")
                    .select("ul")
                    .select("li")
                    .select("span")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeNow = Jsoup.connect("http://www.ilbe.com/list/politics").get();  //일베 최근
            Elements E_ilbeNow = ilbeNow.select("[class=\"subject\"]");

            K_ilbeNow = E_ilbeNow.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeNowSite = Jsoup.connect("http://www.ilbe.com/list/politics").get();  //일베 최근 사이트
            Elements E_ilbeNowSite = ilbeNowSite.select("[class=\"board-list\"]")
                    .select("ul")
                    .select("li")
                    .select("span")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeBestAll = Jsoup.connect("http://www.ilbe.com/list/ilbe?sub=best").get();  //일베 전체 베스트
            Elements E_ilbeBestAll = ilbeBestAll.select("[class=\"subject\"]");

            K_ilbeBestAll = E_ilbeBestAll.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeBestAllSite = Jsoup.connect("http://www.ilbe.com/list/ilbe?sub=best").get();  //일베 전체 베스트 사이트
            Elements E_ilbeBestAllSite = ilbeBestAllSite.select("[class=\"board-list\"]")
                    .select("ul")
                    .select("li")
                    .select("span")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeNowAll = Jsoup.connect("http://www.ilbe.com/list/ilbe").get();  //일베 전체 최근
            Elements E_ilbeNowAll = ilbeNowAll.select("[class=\"subject\"]");

            K_ilbeNowAll = E_ilbeNowAll.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ilbeNowAllSite = Jsoup.connect("http://www.ilbe.com/list/ilbe").get();  //일베 전체 최근 사이트
            Elements E_ilbeNowAllSite = ilbeNowAllSite.select("[class=\"board-list\"]")
                    .select("ul")
                    .select("li")
                    .select("span")
                    .select("a[href]");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouBest = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=sisa&kind=best").get();  //오유 베스트
            Elements E_ouBest = ouBest.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a");

            K_ouBest = E_ouBest.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouBestSite = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=sisa&kind=best").get();  //오유 베스트 사이트
            Elements E_ouBestSite = ouBestSite.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouNow = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=sisa").get();  //오유 최근
            Elements E_ouNow = ouNow.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a");

            K_ouNow = E_ouNow.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouNowSite = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=sisa").get();  //오유 최근 사이트
            Elements E_ouNowSite = ouNow.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouBestAll = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=humorbest").get();  //오유 전체 베스트 (오늘의 베스트)
            Elements E_ouBestAll = ouBestAll.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a");

            K_ouBestAll = E_ouBestAll.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouBestAllSite = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=humorbest").get();  //오유 전체 베스트 (오늘의 베스트)
            Elements E_ouBestAllSite = ouBestAllSite.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a[href]");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouNowAll = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=humordata").get();  //오유 전체 최근
            Elements E_ouNowAll = ouNowAll.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a");

            K_ouNowAll = E_ouNowAll.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ouNowAllSite = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=humordata").get();  //오유 전체 최근 사이트
            Elements E_ouNowAllSite = ouNowAllSite.select("[class=\"table_container\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("[class=\"subject\"]")
                    .select("a");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebBest = Jsoup.connect("http://bbs.ruliweb.com/community/board/300148?view_best=1&cate=527").get();  //루리웹 베스트
            Elements E_ruliwebBest = ruliwebBest.select("[class=\"board_main theme_default\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a");

            K_ruliwebBest = E_ruliwebBest.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebBestSite = Jsoup.connect("http://bbs.ruliweb.com/community/board/300148?view_best=1&cate=527").get();  //루리웹 베스트 사이트
            Elements E_ruliwebBestSite = ruliwebBestSite.select("[class=\"board_main theme_default\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebNow = Jsoup.connect("http://bbs.ruliweb.com/community/board/300148?cate=527").get();
            Elements E_ruliwebNow = ruliwebNow.select("[class=\"board_main theme_default\"]")  //루리웹 최신 글
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a");

            K_ruliwebNow = E_ruliwebNow.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebNowSite = Jsoup.connect("http://bbs.ruliweb.com/community/board/300148?cate=527").get();
            Elements E_ruliwebNowSite = ruliwebNowSite.select("[class=\"board_main theme_default\"]")  //루리웹 최신 글 사이트
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebBestAll = Jsoup.connect("http://bbs.ruliweb.com/community/board/300148?view_best=1").get();  //루리웹 전체 베스트
            Elements E_ruliwebBestAll = ruliwebBestAll.select("[class=\"board_main theme_default\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a");

            K_ruliwebBestAll = E_ruliwebBestAll.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebBestAllSite = Jsoup.connect("http://bbs.ruliweb.com/community/board/300148?view_best=1").get();  //루리웹 전체 베스트 사이트
            Elements E_ruliwebBestAllSite = ruliwebBestAllSite.select("[class=\"board_main theme_default\"]")
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebNowAll = Jsoup.connect("https://bbs.ruliweb.com/community/board/300148").get();
            Elements E_ruliwebNowAll = ruliwebNowAll.select("[class=\"board_main theme_default\"]")  //루리웹 전체 최신 글
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a");

            K_ruliwebNowAll = E_ruliwebNowAll.eachText();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Document ruliwebNowAllSite = Jsoup.connect("https://bbs.ruliweb.com/community/board/300148").get();
            Elements E_ruliwebNowAllSite = ruliwebNowAllSite.select("[class=\"board_main theme_default\"]")  //루리웹 전체 최신 글 사이트
                    .select("table")
                    .select("tbody")
                    .select("tr")
                    .select("td")
                    .select("[class=\"relative\"]")
                    .select("a[href]");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            String a = "";
            String[] H_ilbeBestSite = new String[32];
            String[] H_ilbeNowSite = new String[32];
            String[] H_ilbeBestAllSite = new String[32];
            String[] H_ilbeNowAllSite = new String[32];

            String[] H_ouBestSite = new String[30];
            String[] H_ouNowSite = new String[30];
            String[] H_ouBestAllSite = new String[30];
            String[] H_ouNowAllSite = new String[30];

            String[] H_ruliwebBestSite = new String[28];
            String[] H_ruliwebNowsite = new String[28];
            String[] H_ruliwebBestAllSite = new String[28];
            String[] H_ruliwebNowAllSite = new String[28];

            int I=0;
            for (Element link : E_ilbeBestSite) {
                if ("http://www.ilbe.comjavascript:;".equals("http://www.ilbe.com" + link.attr("href")) == false) {   //널포인터에셉션은 내 친~구~
                    H_ilbeBestSite[I] = "http://www.ilbe.com" + link.attr("href");
                }
                else continue;
                System.out.println(H_ilbeBestSite[I]);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ouBestSite) {
                H_ouBestSite[I] = "http://www.todayhumor.co.kr" + link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ruliwebBestSite) {
                H_ruliwebBestSite[I] = link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ilbeNowSite) {
                if ("http://www.ilbe.comjavascript:;".equals("http://www.ilbe.com" + link.attr("href")) == false) {
                    H_ilbeNowSite[I] = "http://www.ilbe.com" + link.attr("href");
                }
                else continue;
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ouNowSite) {
                H_ouNowSite[I] = "http://www.todayhumor.co.kr" + link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ruliwebNowSite) {
                H_ruliwebNowsite[I] = link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ilbeBestAllSite) {
                if ("http://www.ilbe.comjavascript:;".equals("http://www.ilbe.com" + link.attr("href")) == false) {
                    H_ilbeBestAllSite[I] = "http://www.ilbe.com" + link.attr("href");
                }
                else continue;
                System.out.println(a);
                I++;
            }

            I=0;
            for (Element link : E_ouBestAllSite) {
                H_ouBestAllSite[I] = "http://www.todayhumor.co.kr" + link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ruliwebBestAllSite) {
                H_ruliwebBestAllSite[I] = link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ilbeNowAllSite) {
                if ("http://www.ilbe.comjavascript:;".equals("http://www.ilbe.com" + link.attr("href")) == false) {
                    H_ilbeNowAllSite[I] = "http://www.ilbe.com" + link.attr("href");
                }
                else continue;
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ouNowAllSite) {
                H_ouNowAllSite[I] = "http://www.todayhumor.co.kr" + link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            I=0;
            for (Element link : E_ruliwebNowAllSite) {
                H_ruliwebNowAllSite[I] = link.attr("href");
                System.out.println(a);
                I++;
            }
            System.out.println();

            System.out.println("<< 일간베스트 정치/시사 인기글 나열 >>");
            for (int i = 0; i < K_ilbeBest.size(); i++) {
                System.out.println((i + 1) + ". " + K_ilbeBest.get(i));
            }
            System.out.println();

            System.out.println("<<  오늘의유머 시사게시판 최근 베스트 (베스트 예감) 나열 >>");
            for (int i = 0; i < K_ouBest.size(); i++) {
                System.out.println((i + 1) + ". " + K_ouBest.get(i));
            }
            System.out.println();

            System.out.println("<< 루리웹 정치유머게시판 베스트 나열 >>");
            for (int i = 0; i < K_ruliwebBest.size(); i++) {
                System.out.println((i + 1) + ". " + K_ruliwebBest.get(i));
            }
            System.out.println();

            System.out.println("<< 일간베스트 정치/시사 최신 글 나열 >>");
            for (int i = 0; i < K_ilbeNow.size(); i++) {
                System.out.println((i + 1) + ". " + K_ilbeNow.get(i));
            }
            System.out.println();

            System.out.println("<< 오늘의유머 시사게시판 최신 글 나열 >>");
            for (int i = 0; i < K_ouNow.size(); i++) {
                System.out.println((i + 1) + ". " + K_ouNow.get(i));
            }
            System.out.println();

            System.out.println(" << 루리웹 정치유머게시판 최신 글 나열 >>");
            for (int i = 0; i < K_ruliwebNow.size(); i++) {
                System.out.println((i + 1) + ". " + K_ruliwebNow.get(i));
            }
            System.out.println();

            listview1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() > 1) {
                        int A = listview1.getSelectionModel().getSelectedIndex();
                        try {
                            if(whatIsCBList()==2){
                                if(bestButtonOn1==true) Desktop.getDesktop().browse(new URI(H_ilbeBestSite[A + 2]));
                                else Desktop.getDesktop().browse(new URI(H_ilbeNowSite[A + 2]));
                            }
                            else{
                                if(bestButtonOn1==true) Desktop.getDesktop().browse(new URI(H_ilbeBestAllSite[A + 2]));
                                else Desktop.getDesktop().browse(new URI(H_ilbeNowAllSite[A + 2]));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            listview2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() > 1) {
                        int A = listview2.getSelectionModel().getSelectedIndex();
                        try {
                            if(whatIsCBList()==2){
                                if(bestButtonOn2==true) Desktop.getDesktop().browse(new URI(H_ouBestSite[A]));
                                else Desktop.getDesktop().browse(new URI(H_ouNowSite[A]));
                            }
                            else{
                                if(bestButtonOn2==true) Desktop.getDesktop().browse(new URI(H_ouBestAllSite[A]));
                                else Desktop.getDesktop().browse(new URI(H_ouNowAllSite[A]));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            listview3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() > 1) {
                        int A = listview3.getSelectionModel().getSelectedIndex();
                        try {
                            if(whatIsCBList()==2){
                                if(bestButtonOn3==true) Desktop.getDesktop().browse(new URI(H_ruliwebBestSite[A]));
                                else Desktop.getDesktop().browse(new URI(H_ruliwebNowsite[A]));
                            }
                            else{
                                if(bestButtonOn3==true) Desktop.getDesktop().browse(new URI(H_ruliwebBestAllSite[A]));
                                else Desktop.getDesktop().browse(new URI(H_ruliwebNowAllSite[A]));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < 25; i++) {
            ilbeBest.add(K_ilbeBest.get(i + 2));
            ilbeNow.add(K_ilbeNow.get(i + 2));
            ilbeBestAll.add(K_ilbeBestAll.get(i + 2));
            ilbeNowAll.add(K_ilbeNowAll.get(i + 2));

            ouBest.add(K_ouBest.get(i));
            ouNow.add(K_ouNow.get(i));
            ouBestAll.add(K_ouBestAll.get(i));
            ouNowAll.add(K_ouNowAll.get(i));

            ruriwebBest.add(K_ruliwebBest.get(i));
            ruriwebNow.add(K_ruliwebNow.get(i));
            ruriwebBestAll.add(K_ruliwebBestAll.get(i));
            ruriwebNowAll.add(K_ruliwebNowAll.get(i));
        }

        listview1.setItems(ilbeBest);
        listview2.setItems(ouBest);
        listview3.setItems(ruriwebBest);

        CB.setItems(CBList);
    }


    public int whatIsCBList(){
        if("전체".equals(CB.getValue())) return 1;
        else if("정치/시사".equals(CB.getValue())) return 2;
        else return 2;
    }

    public void combobox(ActionEvent event){
        if(whatIsCBList()==2){
            listview1.setItems(ilbeBest);
            listview2.setItems(ouBest);
            listview3.setItems(ruriwebBest);
        }
        else if(whatIsCBList()==1){
            listview1.setItems(ilbeBestAll);
            listview2.setItems(ouBestAll);
            listview3.setItems(ruriwebBestAll);
        }
        bestButtonOn1=true;
        bestButtonOn2=true;
        bestButtonOn3=true;
    }

    public void buttonNow1(ActionEvent event){
        if(whatIsCBList()==2) listview1.setItems(ilbeNow);
        else listview1.setItems(ilbeNowAll);
        bestButtonOn1=false;
    }

    public void buttonNow2(ActionEvent event) {
        if(whatIsCBList()==2) listview2.setItems(ouNow);
        else listview2.setItems(ouNowAll);
        bestButtonOn2=false;
    }

    public void buttonNow3(ActionEvent event){
        if(whatIsCBList()==2) listview3.setItems(ruriwebNow);
        else listview3.setItems(ruriwebNowAll);
        bestButtonOn3=false;
    }

    public void buttonBest1(ActionEvent event){
        if(whatIsCBList()==2) listview1.setItems(ilbeBest);
        else listview1.setItems(ilbeBestAll);
        bestButtonOn1=true;
    }

    public void buttonBest2(ActionEvent event){
        if(whatIsCBList()==2) listview2.setItems(ouBest);
        else listview2.setItems(ouBestAll);
        bestButtonOn2=true;
    }

    public void buttonBest3(ActionEvent event){
        if(whatIsCBList()==2) listview3.setItems(ruriwebBest);
        else listview3.setItems(ruriwebBestAll);
        bestButtonOn3=true;
    }
}