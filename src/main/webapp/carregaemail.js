function carregaremail(element) {
    var pessoasArray = [];

    if (document.getElementById('destinatarios').value !== '') {
        pessoasArray = document.getElementById('destinatarios').value.split(",");
    }

    if (pessoasArray.indexOf(element.value) === -1) {
        pessoasArray.push(element.value);
        element.style.color = 'black';
        element.style.background = '#f2f2f2';
        element.style.fontWeight = '800';
    } else {
        pessoasArray.splice(pessoasArray.indexOf(element.value), 1);
        element.disable = false;
        element.style.color = 'white';
        element.style.background = '#71a117';
        element.style.fontWeight = 'normal';
    }

    var numuerosDeBotaos = document.getElementsByClassName('emails');

    pessoasArray.sort(function(a, b) {
        return a - b
    });
    document.getElementById('destinatarios').value = pessoasArray;
}