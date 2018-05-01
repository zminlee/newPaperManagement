/**
 * Created by DoveXL on 2017/10/27.
 */
var charts;
$(document).ready(function () {
    $("#collapseOne").show(1);
    $("#collapseTwo").hide();
    $("#collapseThree").hide();

    var option = {
        title:{
            text:'一周变化情况',
            x:'center',
            textStyle: {
                fontSize: 18,
                fontWeight: 'bolder',
                color: '#333', // 主标题文字颜色
            },
        },
        tooltip:{},
        legend:{
            data:['用户来源']
        },
        xAxis:{
            data:["星期一","星期一","星期一","星期一","星期一","星期一","星期一"]
        },
        yAxis:{
            padding:0

        },
        grid:{
            x:30,
            x2:0
        },
        series:[{
            name:'访问量',
            type:'line',
            smooth:true,
            data:[500,200,360,100,200,0,300]
        }]
    };

    var myChart = echarts.init(document.getElementById('GrowthChart'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
    charts = myChart;
});

$(window).resize(function(){
    $(charts).each(function(index, chart){
        chart.resize();
    });
});



function ShowAndHideOne() {
    $("#collapseOne").toggle(500);
    $("#collapseTwo").hide(500);
    $("#collapseThree").hide(500);
}

function ShowAndHideTwo() {
    $("#collapseTwo").toggle(500);
    $("#collapseOne").hide(500);
    $("#collapseThree").hide(500);
}

function ShowAndHideThree() {
    $("#collapseThree").toggle(500);
    $("#collapseOne").hide(500);
    $("#collapseTwo").hide(500);
}





