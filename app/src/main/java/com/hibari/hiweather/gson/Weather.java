package com.hibari.hiweather.gson;

import java.util.List;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public class Weather {

    @Override
    public String toString() {
        return "Weather{" +
                "HeWeather=" + HeWeather +
                '}';
    }

    private List<HeWeatherBean> HeWeather;

    public List<HeWeatherBean> getHeWeather() {
        return HeWeather;
    }

    public void setHeWeather(List<HeWeatherBean> HeWeather) {
        this.HeWeather = HeWeather;
    }

    public static class HeWeatherBean {

        @Override
        public String toString() {
            return "HeWeatherBean{" +
                    "basic=" + basic +
                    ", update=" + update +
                    ", status='" + status + '\'' +
                    ", now=" + now +
                    ", aqi=" + aqi +
                    ", suggestion=" + suggestion +
                    ", msg='" + msg + '\'' +
                    ", daily_forecast=" + daily_forecast +
                    '}';
        }

        /**
         * basic : {"cid":"CN101190401","location":"苏州","parent_city":"苏州","admin_area":"江苏","cnty":"中国","lat":"43.88684082","lon":"125.32450104","tz":"+8.00","city":"苏州","id":"CN101190401","update":{"loc":"2020-02-13 02:13","utc":"2020-02-12 18:13"}}
         * update : {"loc":"2020-02-13 02:13","utc":"2020-02-12 18:13"}
         * status : ok
         * now : {"cloud":"91","cond_code":"101","cond_txt":"多云","fl":"2","hum":"14","pcpn":"0.0","pres":"1015","tmp":"6","vis":"16","wind_deg":"113","wind_dir":"东南风","wind_sc":"2","wind_spd":"10","cond":{"code":"101","txt":"多云"}}
         * daily_forecast : [{"date":"2020-02-14","cond":{"txt_d":"多云"},"tmp":{"max":"8","min":"-1"}},{"date":"2020-02-15","cond":{"txt_d":"阴"},"tmp":{"max":"7","min":"-4"}},{"date":"2020-02-16","cond":{"txt_d":"多云"},"tmp":{"max":"6","min":"-3"}},{"date":"2020-02-17","cond":{"txt_d":"晴"},"tmp":{"max":"8","min":"-1"}},{"date":"2020-02-18","cond":{"txt_d":"晴"},"tmp":{"max":"7","min":"-4"}},{"date":"2020-02-19","cond":{"txt_d":"多云"},"tmp":{"max":"6","min":"-3"}}]
         * aqi : {"city":{"aqi":"49","pm25":"33","qlty":"优"}}
         * suggestion : {"comf":{"type":"comf","brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"},"sport":{"type":"sport","brf":"较适宜","txt":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"},"cw":{"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}}
         * msg : 所有天气数据均为模拟数据，仅用作学习目的使用，请勿当作真实的天气预报软件来使用。
         */


        private BasicBean basic;
        private UpdateBeanX update;
        private String status;
        private NowBean now;
        private AqiBean aqi;
        private SuggestionBean suggestion;
        private String msg;
        private List<DailyForecastBean> daily_forecast;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBeanX getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBeanX update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class BasicBean {
            @Override
            public String toString() {
                return "BasicBean{" +
                        "cid='" + cid + '\'' +
                        ", location='" + location + '\'' +
                        ", parent_city='" + parent_city + '\'' +
                        ", admin_area='" + admin_area + '\'' +
                        ", cnty='" + cnty + '\'' +
                        ", lat='" + lat + '\'' +
                        ", lon='" + lon + '\'' +
                        ", tz='" + tz + '\'' +
                        ", city='" + city + '\'' +
                        ", id='" + id + '\'' +
                        ", update=" + update +
                        '}';
            }

            /**
             * cid : CN101190401
             * location : 苏州
             * parent_city : 苏州
             * admin_area : 江苏
             * cnty : 中国
             * lat : 43.88684082
             * lon : 125.32450104
             * tz : +8.00
             * city : 苏州
             * id : CN101190401
             * update : {"loc":"2020-02-13 02:13","utc":"2020-02-12 18:13"}
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;
            private String city;
            private String id;
            private UpdateBean update;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                /**
                 * loc : 2020-02-13 02:13
                 * utc : 2020-02-12 18:13
                 */

                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class UpdateBeanX {
            @Override
            public String toString() {
                return "UpdateBeanX{" +
                        "loc='" + loc + '\'' +
                        ", utc='" + utc + '\'' +
                        '}';
            }

            /**
             * loc : 2020-02-13 02:13
             * utc : 2020-02-12 18:13
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            @Override
            public String toString() {
                return "NowBean{" +
                        "cloud='" + cloud + '\'' +
                        ", cond_code='" + cond_code + '\'' +
                        ", cond_txt='" + cond_txt + '\'' +
                        ", fl='" + fl + '\'' +
                        ", hum='" + hum + '\'' +
                        ", pcpn='" + pcpn + '\'' +
                        ", pres='" + pres + '\'' +
                        ", tmp='" + tmp + '\'' +
                        ", vis='" + vis + '\'' +
                        ", wind_deg='" + wind_deg + '\'' +
                        ", wind_dir='" + wind_dir + '\'' +
                        ", wind_sc='" + wind_sc + '\'' +
                        ", wind_spd='" + wind_spd + '\'' +
                        ", cond=" + cond +
                        '}';
            }

            /**
             * cloud : 91
             * cond_code : 101
             * cond_txt : 多云
             * fl : 2
             * hum : 14
             * pcpn : 0.0
             * pres : 1015
             * tmp : 6
             * vis : 16
             * wind_deg : 113
             * wind_dir : 东南风
             * wind_sc : 2
             * wind_spd : 10
             * cond : {"code":"101","txt":"多云"}
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;
            private CondBean cond;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public static class CondBean {
                /**
                 * code : 101
                 * txt : 多云
                 */

                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class AqiBean {
            @Override
            public String toString() {
                return "AqiBean{" +
                        "city=" + city +
                        '}';
            }

            /**
             * city : {"aqi":"49","pm25":"33","qlty":"优"}
             */

            private CityBean city;

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean {
                @Override
                public String toString() {
                    return "CityBean{" +
                            "aqi='" + aqi + '\'' +
                            ", pm25='" + pm25 + '\'' +
                            ", qlty='" + qlty + '\'' +
                            '}';
                }

                /**
                 * aqi : 49
                 * pm25 : 33
                 * qlty : 优
                 */

                private String aqi;
                private String pm25;
                private String qlty;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }
            }
        }

        public static class SuggestionBean {
            @Override
            public String toString() {
                return "SuggestionBean{" +
                        "comf=" + comf +
                        ", sport=" + sport +
                        ", cw=" + cw +
                        '}';
            }

            /**
             * comf : {"type":"comf","brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"}
             * sport : {"type":"sport","brf":"较适宜","txt":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"}
             * cw : {"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             */

            private ComfBean comf;
            private SportBean sport;
            private CwBean cw;

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public static class ComfBean {
                @Override
                public String toString() {
                    return "ComfBean{" +
                            "type='" + type + '\'' +
                            ", brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                /**
                 * type : comf
                 * brf : 较舒适
                 * txt : 白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。
                 */

                private String type;
                private String brf;
                private String txt;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean {
                /**
                 * type : sport
                 * brf : 较适宜
                 * txt : 天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。
                 */

                private String type;
                private String brf;
                private String txt;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                @Override
                public String toString() {
                    return "SportBean{" +
                            "type='" + type + '\'' +
                            ", brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }
            }

            public static class CwBean {
                @Override
                public String toString() {
                    return "CwBean{" +
                            "type='" + type + '\'' +
                            ", brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                /**
                 * type : cw
                 * brf : 较适宜
                 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 */

                private String type;
                private String brf;
                private String txt;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            @Override
            public String toString() {
                return "DailyForecastBean{" +
                        "date='" + date + '\'' +
                        ", cond=" + cond +
                        ", tmp=" + tmp +
                        '}';
            }

            /**
             * date : 2020-02-14
             * cond : {"txt_d":"多云"}
             * tmp : {"max":"8","min":"-1"}
             */

            private String date;
            private CondBeanX cond;
            private TmpBean tmp;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
                this.cond = cond;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public static class CondBeanX {
                @Override
                public String toString() {
                    return "CondBeanX{" +
                            "txt_d='" + txt_d + '\'' +
                            '}';
                }

                /**
                 * txt_d : 多云
                 */

                private String txt_d;

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }
            }

            public static class TmpBean {
                @Override
                public String toString() {
                    return "TmpBean{" +
                            "max='" + max + '\'' +
                            ", min='" + min + '\'' +
                            '}';
                }

                /**
                 * max : 8
                 * min : -1
                 */

                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }
        }
    }
}


