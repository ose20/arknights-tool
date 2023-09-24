-- postgresQL 用の構文

INSERT INTO ranks (id, name, jp_name)
VALUES
  (1, 'common', '基礎'),
  (2, 'basic', '初級'),
  (3, 'intermediate', '中級'),
  (4, 'advanced', '上級'),
  (5, 'epic', '高級')
ON CONFLICT(id) DO NOTHING;

INSERT INTO materials (id, name, rank_id, money_cost, stamina_cost)
VALUES
  (1, '源岩鉱', 1, null, null),
  (2, '破損装置', 1, null, null),
  (3, 'エステル原料', 1, null, null),
  (4, 'ブドウ糖', 1, null, null),
  (5, '異鉄の欠片', 1, null, null),
  (6, 'アケトン試剤', 1, null, null),
  (7, '初級源岩', 2, 100, 1),
  (8, '初級装置', 2, 100, 1),
  (9, '初級エステル', 2, 100, 1),
  (10, '初級糖原', 2, 100, 1),
  (11, '初級異鉄', 2, 100, 1),
  (12, '初級アケトン', 2, 100, 1),
  (13, '合成コール', 3, null, null),
  (14, 'マンガン', 3, null, null),
  (15, '砥石', 3, null, null),
  (16, 'RMA70-12', 3, null, null),
  (17, '人工ゲル', 3, null, null),
  (18, '熾合金', 3, null, null),
  (19, '素子結晶', 3, null, null),
  (20, '半自然溶剤', 3, null, null),
  (21, '切削液', 3, null, null),
  (22, '転化塩', 3, null, null),
  (23, '中級源岩', 3, 200, 2),
  (24, '中級装置', 3, 200, 2),
  (25, '中級エステル', 3, 200, 2),
  (26, '中級糖原', 3, 200, 2),
  (27, '中級異鉄', 3, 200, 2),
  (28, '中級アケトン', 3, 200, 2),
  (29, '上級合成コール', 4, 300, 4),
  (30, '上級マンガン', 4, 300, 4),
  (31, '上級砥石', 4, 300, 4),
  (32, 'RMA70-24', 4, 300, 4),
  (33, '融合ゲル', 4, 300, 4),
  (34, '上級熾合金', 4, 300, 4),
  (35, '結晶回路', 4, 300, 4),
  (36, '精練溶剤', 4, 300, 4),
  (37, '上級切削液', 4, 300, 4),
  (38, '上級転化塩', 4, 300, 4),
  (39, '上級源岩', 4, 300, 4),
  (40, '上級装置', 4, 300, 4),
  (41, '上級エステル', 4, 300, 4),
  (42, '上級糖原', 4, 300, 4),
  (43, '上級異鉄', 4, 300, 4),
  (44, '上級アケトン', 4, 300, 4),
  (45, 'D32鋼', 5, 400, 8),
  (46, 'ナノフレーク', 5, 400, 8),
  (47, '融合剤', 5, 400, 8),
  (48, '結晶制御装置', 5, 400, 8),
  (49, '焼結核凝晶', 5, 400, 8)
ON CONFLICT(id) DO NOTHING;

INSERT INTO material_recipes (id, res_mat_id, needed_mat_id, quantity)
VALUES
  (1, 7, 1, 3),
  (2, 8, 2, 3),
  (3, 9, 3, 3),
  (4, 10, 4, 3),
  (5, 11, 5, 3),
  (6, 12, 6, 3),
  (7, 23, 7, 5),
  (8, 24, 8, 4),
  (9, 25, 9, 4),
  (10, 26, 10, 4),
  (11, 27, 11, 4),
  (12, 28, 12, 4),
  (13, 29, 13, 1),
  (14, 29, 26, 1),
  (15, 29, 16, 1),
  (16, 30, 14, 2),
  (17, 30, 25, 1),
  (18, 30, 13, 1),
  (19, 31, 15, 1),
  (20, 31, 27, 1),
  (21, 31, 24, 1),
  (22, 32, 16, 1),
  (23, 32, 23, 2),
  (24, 32, 28, 1),
  (25, 33, 27, 1),
  (26, 33, 17, 1),
  (27, 33, 18, 1),
  (28, 34, 24, 1),
  (29, 34, 15, 1),
  (30, 34, 18, 1),
  (31, 35, 19, 2),
  (32, 35, 17, 1),
  (33, 35, 18, 1),
  (34, 36, 20, 1),
  (35, 36, 21, 1),
  (36, 36, 17, 1),
  (37, 37, 21, 1),
  (38, 37, 19, 1),
  (39, 37, 16, 1),
  (40, 38, 22, 1),
  (41, 38, 20, 1),
  (42, 38, 26, 1),
  (43, 39, 23, 4),
  (44, 40, 24, 1),
  (45, 40, 23, 2),
  (46, 40, 15, 1),
  (47, 41, 25, 2),
  (48, 41, 28, 1),
  (49, 41, 13, 1),
  (50, 42, 26, 2),
  (51, 42, 27, 1),
  (52, 42, 14, 1),
  (53, 43, 27, 2),
  (54, 43, 24, 1),
  (55, 43, 25, 1),
  (56, 44, 28, 2),
  (57, 44, 26, 1),
  (58, 44, 14, 1),
  (59, 45, 30, 1),
  (60, 45, 31, 1),
  (61, 45, 32, 1),
  (62, 46, 40, 1),
  (63, 46, 29, 2),
  (64, 47, 39, 1),
  (65, 47, 43, 1),
  (66, 47, 44, 1),
  (67, 48, 35, 1),
  (68, 48, 33, 2),
  (69, 48, 34, 1),
  (70, 49, 38, 1),
  (71, 49, 37, 1),
  (72, 49, 36, 2)
ON CONFLICT(id) DO NOTHING;