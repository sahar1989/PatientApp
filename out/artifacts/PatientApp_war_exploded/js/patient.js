/**
 * Created by sahar on 7/20/2020.
 */
function checkFormat(val){
    if(!val || /^\d{4}\/\d{1,2}\/\d{1,2}$/.test(val) === false){
        alert('Please Enter the correct format')
    }
}

