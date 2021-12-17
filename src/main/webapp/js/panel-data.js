fetch("api/panel-stat-data")
    .then(res => res.json())
    .then(res => {
        res.forEach(item => {
            let dataCard = `
            <div class="data-card">
            <div class="data-card-title-box">
                <i class="mdui-list-item-icon mdui-icon material-icons"
                >${item.icon}</i
                >
                <span class="data-card-title">${item.name}</span>
            </div>
            <div class="data-card-data-box">${item.count}</div>
            <div class="data-card-info-box">上次发布时间：${item["last-date"]}</div>
        </div>`;
            //html结束
            $(".data-card-box").append(dataCard);
        })
    })