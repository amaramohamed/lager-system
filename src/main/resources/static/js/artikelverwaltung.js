$(document).ready(function() {
	$.ajax({
        url: "http://localhost:1234/get",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
        	
        	//Artikelliste durchlauf
        	for (var i = 0; i < data.length; i++){
        		var panelBody = "";
        		panelBody += "<div class=\"single-products-catagory clearfix\">";
        		panelBody += "<a href=\"shop.html\">";
        		panelBody += "<img id=\""+ data[i].artikelBild +"\" src=\""+ data[i].artikelBild +"\">";
        		panelBody += "<div class=\"hover-content\">";
        		panelBody += "<div class=\"line\"><\/div>";
        		panelBody += "<p><span id=\""+ data[i].artikelPreis + "\">"+ data[i].artikelPreis + "<\/span> €<\/p>";
        		panelBody += "<h4><span id=\""+ data[i].artikelBezeichnung + "\">"+ data[i].artikelBezeichnung + "<\/span><\/h4>";
        		panelBody += "  <\/div>";
        		panelBody += "  <\/a>";
        		panelBody += "  <\/div>";
        		$('.amado-pro-catagory').parent().append(panelBody);
        	}
        		 /*
            $('#artikelBild').attr('src', data[0].artikelBild);
            $('#artikelPreis').text(data[0].artikelPreis);
            $('#artikelBezeichnung').text(data[0].artikelBezeichnung);
            */
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Fehlermeldung :(');
        }
    });
	});