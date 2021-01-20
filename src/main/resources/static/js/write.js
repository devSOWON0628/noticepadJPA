	let id = sessionStorage.length;   
    let title = document.getElementById("title");
    let writer = document.getElementById("writer");
    let content = document.getElementById("content");
    
    UpdateCard();
    
    function Save() {
    let i=0;
    while(sessionStorage.getItem(i) != null) i++;
    id = i;
    console.log(i);
    	if (0==CheckInput()) return;
        let valueTitle = title.value;
        let valueWriter = writer.value;
        let valueContent = content.value;
        
    	let result = document.querySelector('#image').files[0];
    	let	saveDetail;    
        if(typeof result == "undefined"){
        	saveDetail= [
            	{name:"title"  , value: valueTitle  },
        		{name:"writer" , value: valueWriter },
        		{name:"content", value: valueContent},
        		{name:"img"    , value: null}
        	];
        	sessionStorage.setItem(id++, JSON.stringify(saveDetail));
        }else{
            let fileReader = new FileReader();
            fileReader.readAsDataURL(result);
            fileReader.onload = function  () {
            	result = fileReader.result;
            	saveDetail= [
                	{name:"title"  , value: valueTitle  },
            		{name:"writer" , value: valueWriter },
            		{name:"content", value: valueContent},
            		{name:"img"    , value: result}
            	];
            	sessionStorage.setItem(id++, JSON.stringify(saveDetail));
            };
        }
        $("#form")[0].reset(); // form에 있던 내용들을 전부 삭제
        location.reload(); //화면 새로고침
    };

    // form 유효성 확인
    function CheckInput(){ 
		if(title.value.trim() == ''){
			document.getElementById("warning").innerHTML = "제목을 입력해주세요!";
			title.focus();
			return 0;
		}else if(writer.value.trim() == ''){
			document.getElementById("warning").innerHTML = "작성자를 입력해주세요!";
			writer.focus();
			return 0;
		}else if(content.value.trim() == ''){
			document.getElementById("warning").innerHTML = "내용을 입력해주세요!";
			content.focus();
			return 0;
        }
        return 1;
    }
    function plus(i){
    	if(sessionStorage.getItem(i) == null)return;
    	var row;
        let arr_values = JSON.parse(sessionStorage.getItem(i));
    	if(arr_values[3].value==null){
            	row += '<div class="col-sm-6 col-lg-4 mb-4">'+
                '<div class="card mb-4 shadow-sm">'+
                    '<div class="card-body">'+
                        '<a class ="card-text" href="/read?num='+i+'"><h5>'+ arr_values[0].value+'</h5></a>'+
                        '<p class="card-text">'+ arr_values[2].value+'</p>'+
                        '<div class="d-flex justify-content-between align-items-center">'+
                            '<div class="btn-group">'+
           				       '<button type="button" class="btn btn-sm btn-outline-secondary" onclick="targetFunction('+i+')">View</button>'+
           					   '<button type="button" class="btn btn-sm btn-outline-secondary" onclick="edit('+i+')">Edit</button>'+
         				   '</div>'+
                            '<small class="text-muted">  by '+ arr_values[1].value+'</small>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
            '</div>';
            }else if(arr_values[3].value!=null){
            	row += '<div class="col-sm-6 col-lg-4 mb-4">'+
                '<div class="card mb-4 shadow-sm">'+
                '<img class="bd-placeholder-img card-img-top" width="100%" src="'+ arr_values[3].value+'" role="img" aria-label="Placeholder: Image cap" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#868e96"></rect></img>'+
                    '<div class="card-body">'+
                        '<a class ="card-text" href="/read?num='+i+'"><h5>'+ arr_values[0].value+'</h5></a>'+
                        '<p class="card-text">'+ arr_values[2].value+'</p>'+
                        '<div class="d-flex justify-content-between align-items-center">'+
                            '<div class="btn-group">'+
           				       '<button type="button" class="btn btn-sm btn-outline-secondary" onclick="targetFunction('+i+')">View</button>'+
           					   '<button type="button" class="btn btn-sm btn-outline-secondary" onclick="edit('+i+')">Edit</button>'+
         				   '</div>'+
                            '<small class="text-muted">  by '+ arr_values[1].value+'</small>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
            '</div>';
                }
               return row;
    
    }
    function UpdateCard(){
        const count = sessionStorage.length;
        if(count==0){
        	document.getElementById("inner").innerHTML = "데이터가 없습니다.";
        	$('#sessionClear').remove();
	        return;
        }
        document.getElementById("inner").innerHTML = "";
        let row = "";
        const date = new Date();
        let i = 0;
        while(!(sessionStorage.getItem(i) == null && sessionStorage.getItem(i+1) == null)){
        row+=plus(i);
        i++;
        }
        $("#inner").append(row);
    }
    
    function SessionClear(){
        sessionStorage.clear(); // 세션 스토리지를 삭제
        location.reload(); // 화면 새로고침
		}
	
    function targetFunction(num){
		location.href="/read?num="+num;
        }
        
    function edit(num){
	let arr_values = JSON.parse(sessionStorage.getItem(num));

    title.value = arr_values[0].value;
    writer.value = arr_values[1].value;
    content.value = arr_values[2].value;
    
    sessionStorage.removeItem(num);
	}