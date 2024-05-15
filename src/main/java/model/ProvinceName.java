package model;

import java.util.List;

public class ProvinceName {
    private ProvinceName() {
    }

    private static class ProvinceHelper {
        private static final List<String> provinceList =
                List.of("Azarbayjan Sharghi",
                        "Azarbaijan Gharbi",
                        "Ardabil",
                        "Esfahan",
                        "Alborz",
                        "Ilam",
                        "Bosher",
                        "Tehran",
                        "Char Mahal Bakhtiari",
                        "Khorasan Jonobi",
                        "Khorasan Razavi",
                        "Khorasan Shomali",
                        "Khozestan",
                        "Zanjan",
                        "Semnan",
                        "Sistan Va Balochestan",
                        "Fars",
                        "Ghazvin",
                        "Ghom",
                        "Kordestan",
                        "Kerman",
                        "Kermanshah",
                        "Kohkiloyeh Va Boier Ahmad",
                        "Golestan",
                        "Gilan",
                        "Lorestan",
                        "Mazandaran",
                        "Markazi",
                        "Hormozgan",
                        "Hamedan",
                        "Yazd");
        private static final List<String> KalanShahrList =
                List.of(provinceList.get(0),
                        provinceList.get(3),
                        provinceList.get(4),
                        provinceList.get(10),
                        provinceList.get(12),
                        provinceList.get(16),
                        provinceList.get(18),
                        provinceList.get(24));
        private static final String capitalCity = provinceList.get(7);
    }

    public static List<String> getProvinceList() {
        return ProvinceHelper.provinceList;
    }

    public static List<String> getKalanShahrList() {
        return ProvinceHelper.KalanShahrList;
    }

    public static String getCapitalCity() {
        return ProvinceHelper.capitalCity;
    }
}
