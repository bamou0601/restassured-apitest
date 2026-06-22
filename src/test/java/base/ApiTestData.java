package base;

import java.util.Map;

/**
 * APIテストデータDTO（リクエスト・期待値管理用）
 *
 * 目的:
 * - テストデータを一元管理（DRY化）
 * - request / expected をセットで保持
 * - JSON等外部データと連携可能
 *
 * 注意:
 * - Map型のため型安全性は低い
 * - 検証はテスト側で実施
 * - 小〜中規模テスト向け設計
 * 作成者: 馬 猛
 * 作成日: 2026/06/22
 */

import lombok.Data;

@Data
public class ApiTestData {
	
	// TC名（識別）
    private String name; 
    
    // Reqデータ
    private Map<String, Object> request;
    
    // 期待値
    private Map<String, Object> expected;
}




